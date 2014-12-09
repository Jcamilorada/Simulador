package simulator.infusion.calculations;

import com.google.common.base.Preconditions;
import simulator.infusion.CalculationRequest;
import simulator.infusion.CalculationResponse;
import simulator.infusion.IModel;
import simulator.infusion.PumpInfusion;

import java.util.Collections;
import java.util.List;

/**
 * @author Alejandro Valdes
 */
public class PumpSolver
{
    final IModel model;
    List<Double> lambda;
    double[] plasmaCoefficients = new double[4];
    double[] effectSiteCoefficients = new double[4];
    final double l1;
    final double l2;
    final double l3;
    final double l4;

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
        l1 = Math.exp(-lambda.get(0));
        l2 = Math.exp(-lambda.get(1));
        l3 = Math.exp(-lambda.get(2));
        l4 = Math.exp(-lambda.get(3));
    }

    public CalculationResponse solve(final CalculationRequest request)
    {
        PumpStatus pumpStatus = new PumpStatus(request.getTime());

        int time = 1;
        double infusion = 1;
        while(time < request.getTime())
        {
            if ((time-1) % request.getTime() == 0)
            {
                infusion = findNeededInfusion(request, time, pumpStatus);
                //INFUSION = infusion * 3.6/10;  //no entiendo esto :P
            }
            calculateEffectSiteConcentration(infusion, request.getDeltaTime(), pumpStatus);
            calculatePlasmaConcentration(infusion, request.getDeltaTime(), pumpStatus);
            time += request.getDeltaTime();

        }
        CalculationResponse response = new CalculationResponse();
        response.setInfusionList(Collections.singletonList(new PumpInfusion(time, infusion)));
        response.setPlasmaConcentrationsData(pumpStatus.getPlasmaUdf());
        response.setSiteConcentrationsData(pumpStatus.getEffectSiteUdf());
        return response;
    }

    private double findNeededInfusion(
        final CalculationRequest request, final int time, final PumpStatus oldPumpStatus)
    {
        double error = 1;
        double infusion = 1;
        while (Math.abs(error) > 0.05)
        {
            PumpStatus pumpStatus = new PumpStatus(oldPumpStatus);
            calculateEffectSiteConcentration(infusion, request.getTime(), pumpStatus);
            error =
                (pumpStatus.getLatestEffectSiteUdf() - request.getConcentration())
                / request.getConcentration();
            if (Math.abs(error) > 0.005)
            {
                infusion = infusion * (1 - error);
            }
            if (infusion < 1)  //si esto sucede es mejor apagar la bomba.
            {
                infusion = 0;
                int additionalTime = time + request.getTime();
                while (pumpStatus.getLatestEffectSiteUdf() > request.getConcentration())
                {
                    additionalTime++;
                    calculateEffectSiteConcentration(1, 1, pumpStatus);
                }
                request.setTime((int) Math.round(((double) additionalTime)/60D)* 60);
                System.out.println(request.getTime());  //TODO
                break;
            }
        }
        return infusion;
    }

    private void calculatePlasmaConcentration(
        final double infusion, int deltaTime, final PumpStatus pumpStatus)
    {
        for (int i = 0; i < deltaTime; i++)
        {
            pumpStatus.storePlasmaUdfValue(
                pumpStatus.getPTemp1() * l1 + plasmaCoefficients[0] * infusion * (1 - l1),
                pumpStatus.getPTemp2() * l2 + plasmaCoefficients[1] * infusion * (1 - l2),
                pumpStatus.getPTemp3() * l3 + plasmaCoefficients[2] * infusion * (1 - l3));
        }
    }

    private void calculateEffectSiteConcentration(
        final double infusion, final int deltaTime, final PumpStatus pumpStatus)
    {
        for (int iterator = 0 ; iterator < deltaTime; iterator++)
        {
            pumpStatus.storeEffectSiteUdfValue(
                pumpStatus.getTemp1() * l1 + effectSiteCoefficients[0] * infusion * (1 - l1),
                pumpStatus.getTemp2() * l2 + effectSiteCoefficients[1] * infusion * (1 - l2),
                pumpStatus.getTemp3() * l3 + effectSiteCoefficients[2] * infusion * (1 - l3),
                pumpStatus.getTemp4() * l4 + effectSiteCoefficients[3] * infusion * (1 - l4));
        }

    }
}
