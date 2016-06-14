package simulator.domain.infusion;


import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.configuration.PumpProperties;
import simulator.domain.infusion.calculations.PumpSolver;
import simulator.domain.infusion.model.ModelFactory;

@Component
public class InfusionService
{
    private final PumpProperties pumpProperties;

    @Autowired
    public InfusionService(final PumpProperties pumpProperties)
    {
        this.pumpProperties = Preconditions.checkNotNull(pumpProperties);
    }

    public CalculationResponse processSimulation(final CalculationRequest request)
    {
        PumpSolver pumpSolver = new PumpSolver(
                pumpProperties, ModelFactory.getModel(request.getModel(), request.getPatient()));

        CalculationResponse response = pumpSolver.solve(request);
        return response;
    }

}
