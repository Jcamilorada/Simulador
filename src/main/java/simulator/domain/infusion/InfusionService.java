package simulator.domain.infusion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.model.Model;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;
import simulator.domain.infusion.calculations.PumpSolver;
import simulator.domain.infusion.model.ModelFactory;
import simulator.restservices.mappers.InfusionMapper;

@Component
public class InfusionService
{
    private final InfusionMapper infusionMapper;
    private final PumpSolver pumpSolver;

    @Autowired
    public InfusionService(final InfusionMapper infusionMapper, final PumpSolver pumpSolver)
    {
        this.infusionMapper = infusionMapper;
        this.pumpSolver = pumpSolver;


    }

    public CalculationResponse processSimulation(final CalculationRequest request)
    {
        pumpSolver.setModel(ModelFactory.getModel(request.getModel(), request.getPatient()));
        CalculationResponse response = pumpSolver.solve(request);
        return response;
    }
}
