package simulator.restservices.infusion;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.common.ObjectMapper;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.CalculationResponse;
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
    private ObjectMapper objectMapper;

    @Autowired
    public InfusionResource(
        final InfusionService infusionService, final InfusionMapper infusionMapper, final ObjectMapper objectMapper)
    {
        this.infusionService = Preconditions.checkNotNull(infusionService);
        this.infusionMapper = Preconditions.checkNotNull(infusionMapper);
        this.objectMapper = Preconditions.checkNotNull(objectMapper);
    }

    @RequestMapping(value = "/solve", method = RequestMethod.PUT)
    public
    @ResponseBody
    CalculationResponseDTO getMesh(@RequestBody CalculationRequestDTO requestDTO)
    {
        CalculationRequest request = objectMapper.map(requestDTO, CalculationRequest.class);
        CalculationResponse response = infusionService.processSimulation(request);

        //return infusionMapper.newCalculationResponseDTO(
          //  infusionService.processSimulation(
            //    infusionMapper.newCalculationRequest(requestDTO)));
        return objectMapper.map(response, CalculationResponseDTO.class);
    }
}
