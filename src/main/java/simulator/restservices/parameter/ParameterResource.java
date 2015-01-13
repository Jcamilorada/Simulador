package simulator.restservices.parameter;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.parameter.IParameterService;

/**
 * @author Juan Camilo Rada
 *
 * System parameters resource. Provide paremters information to the ui.
 */
@Controller
public class ParameterResource
{
    private final IParameterService parameterService;
    private final ParameterMapper parameterMapper;

    @Autowired
    ParameterResource(final IParameterService parameterService, final ParameterMapper parameterMapper)
    {
        this.parameterService = Preconditions.checkNotNull(parameterService, "parameterService cannot be null");
        this.parameterMapper = Preconditions.checkNotNull(parameterMapper, "parameterMapper cannot be null");
    }

    @RequestMapping("/parameters/{id}")
    public
    @ResponseBody
    ParameterDTO getParameter(final @PathVariable long id)
    {
        return parameterMapper.newBusinessObjectDTO(parameterService.getParameter(id));
    }
}