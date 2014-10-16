package configuration;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    String home()
    {
        return "Simulador";
    }
}

