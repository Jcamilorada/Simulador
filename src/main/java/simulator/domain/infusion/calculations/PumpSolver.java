package simulator.domain.infusion.calculations;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.configuration.PumpProperties;
import simulator.domain.infusion.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import simulator.domain.infusion.model.IModel;

/**
 * This class simulates a pump for the given {@link IModel}. Provides the solve method that accepts
 * {@link CalculationRequest} and will return a {@link CalculationResponse}.
 *
 * @author Alejandro Valdes
 */
@Component
public class PumpSolver
{
    private final PumpProperties pumpProperties;
    /** The model in which the simulation is based on. */
    private IModel model;
    private List<Double> lambda;
    private double[] plasmaCoefficients = new double[4];
    private double[] effectSiteCoefficients = new double[4];
    private double l1;
    private double l2;
    private double l3;
    private double l4;

    @Autowired
    public PumpSolver(PumpProperties pumpProperties)
    {
        this.pumpProperties = Preconditions.checkNotNull(pumpProperties);
    }

    /**
     * Sets the model of the solver. This method will initialize all the necessary values and has to be called before
     * using {@code solve}.
     *
     * @param model an instance of {@link IModel}.
     */
    public void setModel(final IModel model)
    {
        Preconditions.checkNotNull(model);
        this.model = model;
        lambda = CubeSolver.solve(
            model.getK(1, 0), model.getK(1, 2), model.getK(2, 1), model.getK(1, 3), model.getK(3, 1));
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
        }
        else
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
            }
            else
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

    /**
     * Solves the given request. Will never return null.
     *
     * @param request an instance of {@link CalculationRequest}.
     *
     * @return a new {@link CalculationResponse} with the simulation results.
     */
    public CalculationResponse solve(final CalculationRequest request)
    {
        Preconditions.checkNotNull(request);
        List<InfusionResponse> infusions = new ArrayList<>();
        PumpStatus pumpStatus = new PumpStatus(request.getMaximumTime());
        int time = 0;
        CalculationResponse response = new CalculationResponse();
        try
        {
            for (InfusionRequest infusionRequest : request.getInfusionRequestList()) {
                int maxDelta = infusionRequest.getEndTime() - infusionRequest.getStartTime();
                boolean isInfusionForPumping = request.isInfusionForPumping(infusionRequest);
                int delta = isInfusionForPumping ? maxDelta : request.getDeltaTime();
                for (int currentDelta = 0; currentDelta < maxDelta; currentDelta+=delta)
                {
                    double infusion = findNeededInfusion(infusionRequest, delta, pumpStatus);
                    calculateEffectSiteConcentration(infusion, delta, pumpStatus);
                    calculatePlasmaConcentration(infusion, delta, pumpStatus);
                    infusions.add(new InfusionResponse(time, infusion * 3.6/10));
                    time += delta;
                }

            }
            response.setInfusionList(infusions);
            response.setPlasmaConcentrationsData(pumpStatus.getPlasmaUdf());
            response.setSiteConcentrationsData(pumpStatus.getEffectSiteUdf());
        }
        catch (InfusionException ie)
        {
            response.setErrorCode(CalculationResponse.ErrorCode.UNREACHABLE_INFUSION);
            response.setInfusionList(
                Collections.singletonList(
                    new InfusionResponse(ie.getRequest().getStartTime(), ie.getRequest().getConcentration())));
        }
        return response;
    }

    private double findNeededInfusion(
        final InfusionRequest request,
        final int deltaTime,
        final PumpStatus oldPumpStatus) throws InfusionException
    {
        final double neededConcentration = request.getConcentration();
        double error = 1;
        double infusion = 1;
        while (Math.abs(error) > pumpProperties.getEpsilon())
        {
            PumpStatus pumpStatus = new PumpStatus(oldPumpStatus);
            calculateEffectSiteConcentration(infusion, deltaTime, pumpStatus);
            error = (pumpStatus.getLatestEffectSiteUdf() - neededConcentration) / neededConcentration;
            if (Math.abs(error) > pumpProperties.getEpsilon())
            {
                infusion = infusion * (1 - error);
            }
            if (infusion < 1) //if this happens it means that we need to turn off the pump.
            {
                infusion = 0;
                pumpStatus = new PumpStatus(oldPumpStatus);
                calculateEffectSiteConcentration(infusion, deltaTime, pumpStatus);
                error = (pumpStatus.getLatestEffectSiteUdf() - neededConcentration) / neededConcentration;
                if (error > pumpProperties.getEpsilon())
                {
                    throw new InfusionException(request);
                }

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
        for (int iterator = 0; iterator < deltaTime; iterator++)
        {
            pumpStatus.storeEffectSiteUdfValue(
                pumpStatus.getTemp1() * l1 + effectSiteCoefficients[0] * infusion * (1 - l1),
                pumpStatus.getTemp2() * l2 + effectSiteCoefficients[1] * infusion * (1 - l2),
                pumpStatus.getTemp3() * l3 + effectSiteCoefficients[2] * infusion * (1 - l3),
                pumpStatus.getTemp4() * l4 + effectSiteCoefficients[3] * infusion * (1 - l4));
        }

    }
}
