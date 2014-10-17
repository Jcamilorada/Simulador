package simulator.restservice;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import simulator.common.SystemParameter;

@Controller
public class IndexController {

    @RequestMapping("/information")
    public @ResponseBody
    SystemParameter home()
    {
        SystemParameter parameter = new SystemParameter();
        parameter.setName("Developer");
        parameter.setValue("Juan Camilo Rada");
        parameter.setDescription("Applicacion developer");
        return parameter;
    }
}

