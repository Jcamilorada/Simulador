package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.services.infusion.InfusionService;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;

@Controller
@RequestMapping("/infusion")
public class InfusionController
{
    private InfusionService infusionService;

    @Autowired
    public InfusionController(InfusionService infusionService)
    {
        this.infusionService = infusionService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.PUT)
    public
    @ResponseBody
    CalculationResponseDTO getMesh(@RequestBody CalculationRequestDTO requestDTO)
    {
        return infusionService.processSimulation(requestDTO);
    }
}
