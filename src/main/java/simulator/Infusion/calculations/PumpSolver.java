package simulator.Infusion.calculations;

import com.google.common.base.Preconditions;
import lombok.Getter;
import simulator.Infusion.IModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alevalv on 11/8/14.
 */
public class PumpSolver
{
    public static final int MAXIMUM_TIME = 2700;
    public static final double EPSILON = 0.005D; //threshold to consider two numbers equal
    public static final int RECALCULATE_DELTA = 20;
    final IModel model;
    List<Double> lambda;
    double[] plasmaCoefficients = new double[4];
    double[] effectSiteCoefficients = new double[4];

    public PumpSolver(final IModel model)
    {
        Preconditions.checkNotNull(model);
        this.model = model;
        lambda = Cube.solve(model.getK(1, 0), model.getK(1, 2), model.getK(2, 1), model.getK(1, 3), model.getK(3, 1));
        Collections.sort(lambda, Collections.reverseOrder());
        lambda.add(model.getK(4, 1));
        if (model.getK(3, 1) > 0D)
        {
            plasmaCoefficients[0] = (model.getK(2, 1) - lambda.get(0)) * (model.getK(3, 1) - lambda.get(0)) /
                (lambda.get(0) - lambda.get(1)) /
                (lambda.get(0) - lambda.get(2)) /
                model.getCentralVolume() / lambda.get(0);
            plasmaCoefficients[1] = (model.getK(2, 1) - lambda.get(1)) * (model.getK(3, 1) - lambda.get(1)) /
                (lambda.get(1) - lambda.get(0)) /
                (lambda.get(1) - lambda.get(2)) /
                model.getCentralVolume() / lambda.get(1);
            plasmaCoefficients[2] = (model.getK(2, 1) - lambda.get(2)) * (model.getK(3, 1) - lambda.get(2)) /
                (lambda.get(2) - lambda.get(1)) /
                (lambda.get(2) - lambda.get(0)) /
                model.getCentralVolume() / lambda.get(2);
            effectSiteCoefficients[0] = plasmaCoefficients[0] / (model.getK(4, 1) - lambda.get(0)) * model.getK(4, 1);
            effectSiteCoefficients[1] = plasmaCoefficients[1] / (model.getK(4, 1) - lambda.get(1)) * model.getK(4, 1);
            effectSiteCoefficients[2] = plasmaCoefficients[2] / (model.getK(4, 1) - lambda.get(2)) * model.getK(4, 1);
            effectSiteCoefficients[3] = (model.getK(4, 1) - model.getK(2, 1)) * (model.getK(4, 1) - model.getK(3, 1)) /
                (lambda.get(0) - model.getK(4, 1)) /
                (lambda.get(1) - model.getK(4, 1)) /
                (lambda.get(2) - model.getK(4, 1)) / model.getCentralVolume();
        } else
        {
            if (model.getK(2, 1) > 0)
            {
                plasmaCoefficients[0] = (model.getK(2, 1) - lambda.get(0)) /
                    (lambda.get(1) - lambda.get(0)) /
                    model.getCentralVolume() / lambda.get(0);
                plasmaCoefficients[1] = (model.getK(2, 1) - lambda.get(1)) /
                    (lambda.get(0) - lambda.get(1)) /
                    model.getCentralVolume() / lambda.get(1);
                plasmaCoefficients[2] = 0;
                effectSiteCoefficients[0] = plasmaCoefficients[0] / (model.getK(4, 1) - lambda.get(0)) * model.getK(4, 1);
                effectSiteCoefficients[1] = plasmaCoefficients[1] / (model.getK(4, 1) - lambda.get(1)) * model.getK(4, 1);
                effectSiteCoefficients[2] = 0;
                effectSiteCoefficients[3] = (model.getK(2, 1) - model.getK(4, 1)) /
                    (lambda.get(0) - model.getK(4, 1)) /
                    (lambda.get(1) - model.getK(4, 1)) / model.getCentralVolume();
            } else
            {
                plasmaCoefficients[0] = 1 / lambda.get(0) / model.getCentralVolume();
                plasmaCoefficients[1] = 0;
                plasmaCoefficients[2] = 0;
                effectSiteCoefficients[0] = plasmaCoefficients[0] / (model.getK(4, 1) - lambda.get(0)) * model.getK(4, 1);
                effectSiteCoefficients[1] = 0;
                effectSiteCoefficients[2] = 0;
                effectSiteCoefficients[3] = 1 / (lambda.get(0) - model.getK(4, 1)) / model.getCentralVolume();
            }
        }
    }

    public int solve(
        final double desiredConcentration, final int timeLimit)
    {
        PumpStatus pumpStatus = new PumpStatus(MAXIMUM_TIME);

        double l1 = Math.exp(-lambda.get(0));
        double l2 = Math.exp(-lambda.get(1));
        double l3 = Math.exp(-lambda.get(2));
        double l4 = Math.exp(-lambda.get(3));

        calculatePlasmaConcentration(l1, l2, l3, pumpStatus);
        calculateConcentrationWhenPumping(l1, l2, l3, l4, desiredConcentration, timeLimit, pumpStatus);
        return findDesiredConcentration(l1, l2, l3, l4, desiredConcentration, pumpStatus, RECALCULATE_DELTA);
    }

    private int findDesiredConcentration(
        final double l1, final double l2, final double l3, final double l4, final double desiredConcentration, final PumpStatus oldPumpStatus, final int delta)
    {
        PumpStatus pumpStatus = new PumpStatus(oldPumpStatus, delta);
        calculateConcentrationWithoutPumping(l1, l2, l3, l4, pumpStatus);
        if (pumpStatus.areWeThereYet(desiredConcentration))
        {
            return findDesiredConcentration(l1, l2, l3, l4, desiredConcentration, oldPumpStatus, delta * 2);
        } else
        {
            return findDesiredConcentrationSecondStep(l1, l2, l3, l4, desiredConcentration, oldPumpStatus, delta - 1);
        }
    }

    private int findDesiredConcentrationSecondStep(
        final double l1, final double l2, final double l3, final double l4, final double desiredConcentration, final PumpStatus oldPumpStatus, final int delta)
    {
        PumpStatus pumpStatus = new PumpStatus(oldPumpStatus, delta);
        calculateConcentrationWithoutPumping(l1, l2, l3, l4, pumpStatus);
        if (pumpStatus.areWeThereYet(desiredConcentration))
        {
            return pumpStatus.iterator;
        } else
        {
            return findDesiredConcentrationSecondStep(l1, l2, l3, l4, desiredConcentration, oldPumpStatus, delta - 1);
        }
    }

    private void calculatePlasmaConcentration(
        final double l1, final double l2, final double l3, final PumpStatus pumpStatus)
    {
        double temp1 = 0;
        double temp2 = 0;
        double temp3 = 0;
        for (int i = 0; i < MAXIMUM_TIME; i++)
        {
            temp1 = temp1 * l1 + plasmaCoefficients[0] * (1 - l1);
            temp2 = temp2 * l2 + plasmaCoefficients[1] * (1 - l2);
            temp3 = temp3 * l3 + plasmaCoefficients[2] * (1 - l3);
            pumpStatus.plasmaUdf.add(temp1 + temp2 + temp3);
        }
    }

    private void calculateConcentrationWhenPumping(
        final double l1, final double l2, final double l3, final double l4, final double desiredConcentration, final int timeLimit, final PumpStatus status)
    {
        while (status.areWeThereYet(desiredConcentration) && status.iterator < timeLimit)
        {
            status.storeStatus(status.getTemp1() * l1 + effectSiteCoefficients[0] * (1 - l1), status.getTemp2() * l2 + effectSiteCoefficients[1] * (1 - l2), status.getTemp3() * l3 + effectSiteCoefficients[2] * (1 - l3), status.getTemp4() * l4 + effectSiteCoefficients[3] * (1 - l4));
            if (status.iterator < timeLimit)
            {
                throw new IllegalArgumentException(String.format("The needed amount is not achievable in '%d' seconds", timeLimit));
            }
        }
    }

    private void calculateConcentrationWithoutPumping(
        final double l1, final double l2, final double l3, final double l4, final PumpStatus status)
    {
        double prior;
        do
        {
            prior = status.getEffectSiteUdf();
            status.storeStatus(status.getTemp1() * l1, status.getTemp2() * l2, status.getTemp3() * l3, status.getTemp4() * l4);
        } while (prior < status.getEffectSiteUdf() && status.iterator < MAXIMUM_TIME);
    }

    private class PumpStatus
    {
        List<Double> effectSiteUdf;
        List<Double> plasmaUdf;
        List<Double> temp1;
        List<Double> temp2;
        List<Double> temp3;
        List<Double> temp4;
        int iterator;
        @Getter
        private int rebuilds;

        PumpStatus(final int maximumTime)
        {
            effectSiteUdf = new ArrayList<>(maximumTime);
            plasmaUdf = new ArrayList<>(maximumTime);
            temp1 = new ArrayList<>(maximumTime);
            temp2 = new ArrayList<>(maximumTime);
            temp3 = new ArrayList<>(maximumTime);
            temp4 = new ArrayList<>(maximumTime);
            temp1.add(0D);
            temp2.add(0D);
            temp3.add(0D);
            temp4.add(0D);
            effectSiteUdf.add(0D);

            iterator = 0;
            rebuilds = 0;
        }

        PumpStatus(final PumpStatus pumpStatus, final int delta)
        {
            effectSiteUdf = new ArrayList<>(pumpStatus.effectSiteUdf.subList(0, Math.max(1, pumpStatus.iterator - delta)));
            plasmaUdf = new ArrayList<>(pumpStatus.plasmaUdf);
            temp1 = new ArrayList<>(pumpStatus.temp1.subList(0, Math.max(1, pumpStatus.iterator - delta)));
            temp2 = new ArrayList<>(pumpStatus.temp2.subList(0, Math.max(1, pumpStatus.iterator - delta)));
            temp3 = new ArrayList<>(pumpStatus.temp3.subList(0, Math.max(1, pumpStatus.iterator - delta)));
            temp4 = new ArrayList<>(pumpStatus.temp4.subList(0, Math.max(1, pumpStatus.iterator - delta)));
            this.iterator = Math.max(0, iterator - delta);
            rebuilds++;
        }

        /**
         * Convenient method to store the actual status of the algorithm.
         * This method will always add to the end of the lists.
         *
         * @param temp1
         * @param temp2
         * @param temp3
         * @param temp4
         */
        void storeStatus(
            final double temp1, final double temp2, final double temp3, final double temp4)
        {
            this.effectSiteUdf.add(temp1 + temp2 + temp3 + temp4);
            this.temp1.add(temp1);
            this.temp2.add(temp2);
            this.temp3.add(temp3);
            this.temp4.add(temp4);
            iterator++;
        }

        double getEffectSiteUdf()
        {
            return effectSiteUdf.get(iterator);
        }

        double getTemp1()
        {
            return temp1.get(iterator);
        }

        double getTemp2()
        {
            return temp2.get(iterator);
        }

        double getTemp3()
        {
            return temp3.get(iterator);
        }

        double getTemp4()
        {
            return temp4.get(iterator);
        }

        boolean areWeThereYet(final double desiredConcentration)
        {
            if (iterator > 1 && (getEffectSiteUdf() - effectSiteUdf.get(iterator - 1)) < 0.000001)
            {
                throw new IllegalStateException("Tangential");
            }
            return (((getEffectSiteUdf() - desiredConcentration) / desiredConcentration) < EPSILON || (getEffectSiteUdf() > desiredConcentration));
        }
    }
}
