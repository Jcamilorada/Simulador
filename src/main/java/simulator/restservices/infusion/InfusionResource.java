package simulator.restservices.infusion;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.CalculationResponse;
import simulator.domain.infusion.InfusionService;

/**
 * @author Juan Camilo Rada
 *
 * {@code CalculationResponse} and  {@code CalculationResponseDTO} mapper.
 */
@Controller
@RequestMapping("/infusion")
public class InfusionResource
{
    private final InfusionService infusionService;

    private final CalculationRequestMapper requestMapper;

    private final CalculationResponseMapper responseMapper;

    @Autowired
    public InfusionResource(
        final InfusionService infusionService,
        final CalculationRequestMapper requestMapper,
        final CalculationResponseMapper responseMapper)
    {
        this.infusionService = Preconditions.checkNotNull(infusionService);
        this.requestMapper = Preconditions.checkNotNull(requestMapper);
        this.responseMapper = Preconditions.checkNotNull(responseMapper);
    }

    @RequestMapping(value = "/solve", method = RequestMethod.PUT)
    public
    @ResponseBody
    CalculationResponseDTO solve(final @RequestBody CalculationRequestDTO requestDTO)
    {
        CalculationRequest request = requestMapper.newBusinessObject(requestDTO);
        CalculationResponse response = infusionService.processSimulation(request);

        return responseMapper.newBusinessObjectDTO(response);
    }
}
