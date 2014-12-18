package simulator.restservices.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.parameter.Parameter;
import simulator.domain.parameter.IParameterService;

@Controller
@RequestMapping("/parameters")
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

    @RequestMapping("/{id}")
    public
    @ResponseBody
    ParameterDTO getParameter(final @PathVariable long id)
    {
        return parameterMapper.newBusinessObjectDTO(parameterService.getSystemParameter(id));
    }
}

