package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import simulator.domain.SystemParameter;
import simulator.services.systemparameter.ISystemParameterService;

@Controller
@RequestMapping("/parameter")
public class ParametersController
{
    private ISystemParameterService parameterService;

    @Autowired
    ParametersController(ISystemParameterService parameterService)
    {
        this.parameterService = parameterService;
    }

    @RequestMapping("/{id}")
    public @ResponseBody SystemParameter getParameter(@PathVariable long id)
    {
        return parameterService.getSystemParameter(1);
    }
}

