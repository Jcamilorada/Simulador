package simulator.restservices;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.infusion.InfusionService;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;
import simulator.restservices.mappers.InfusionMapper;

@Controller
@RequestMapping("/infusion")
public class InfusionResource
{
    private InfusionService infusionService;
    private InfusionMapper infusionMapper;

    @Autowired
    public InfusionResource(final InfusionService infusionService, final InfusionMapper infusionMapper)
    {
        this.infusionService = Preconditions.checkNotNull(infusionService);
        this.infusionMapper = Preconditions.checkNotNull(infusionMapper);
    }

    @RequestMapping(value = "/solve", method = RequestMethod.PUT)
    public
    @ResponseBody
    CalculationResponseDTO getMesh(@RequestBody CalculationRequestDTO requestDTO)
    {
        return infusionMapper.newCalculationResponseDTO(
            infusionService.processSimulation(
                infusionMapper.newCalculationRequest(requestDTO)));
    }
}
