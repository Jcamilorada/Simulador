package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.SystemParameter;
import simulator.services.systemparameter.ISystemParameterService;

@Controller
@RequestMapping("/parameters")
public class ParametersResource
{
    private ISystemParameterService parameterService;

    @Autowired
    ParametersResource(ISystemParameterService parameterService)
    {
        this.parameterService = parameterService;
    }

    @RequestMapping("/{id}")
    public
    @ResponseBody
    SystemParameter getParameter(@PathVariable long id)
    {
        return parameterService.getSystemParameter(1);
    }
}

