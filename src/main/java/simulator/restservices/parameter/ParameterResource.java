package simulator.restservices.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.parameter.Parameter;
import simulator.domain.parameter.IParameterService;

<<<<<<< HEAD
/**
 * @author Juan Camilo Rada
 *
 * System parameters resource. Provide paremters information to the ui.
 */
=======
import java.util.List;

>>>>>>> 6619a1a2579211e7c43147f42169edf3456e69fa
@Controller
public class ParameterResource
{
    private final IParameterService parameterService;
    private final ParameterMapper parameterMapper;

    @Autowired
    ParameterResource(final IParameterService parameterService, final ParameterMapper parameterMapper)
    {
        this.parameterService = parameterService;
        this.parameterMapper = parameterMapper;
    }

    @RequestMapping("/parameters/{id}")
    public
    @ResponseBody
    ParameterDTO getParameterList(final @PathVariable long id)
    {
        return parameterMapper.newBusinessObjectDTO(parameterService.getParameter(id));
    }
}