package simulator.domain.infusion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.calculations.PumpSolver;
import simulator.domain.infusion.model.ModelFactory;

@Component
public class InfusionService
{
    private final PumpSolver pumpSolver;

    @Autowired
    public InfusionService(final PumpSolver pumpSolver)
    {
        this.pumpSolver = pumpSolver;
    }

    public CalculationResponse processSimulation(final CalculationRequest request)
    {
        pumpSolver.setModel(ModelFactory.getModel(request.getModel(), request.getPatient()));
        CalculationResponse response = pumpSolver.solve(request);
        return response;
    }
}
