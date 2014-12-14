package simulator.services.infusion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;
import simulator.infusion.CalculationRequest;
import simulator.infusion.CalculationResponse;
import simulator.infusion.InfusionMapper;
import simulator.infusion.calculations.PumpSolver;
import simulator.infusion.calculations.SchiderModel;

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

    public CalculationResponseDTO processSimulation(final CalculationRequestDTO requestDTO)
    {
        CalculationRequest request = infusionMapper.newCalculationRequest(requestDTO);
        pumpSolver.setModel(new SchiderModel(
            request.getPatient().getWeight(),
            request.getPatient().getHeight(),
            request.getPatient().getAge()
            ));
        CalculationResponse response = pumpSolver.solve(request);
        return infusionMapper.newCalculationResponseDTO(response);
    }
}
