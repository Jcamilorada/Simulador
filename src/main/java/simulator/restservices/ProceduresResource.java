package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.procedure.Procedure;
import simulator.domain.procedure.IProcedureService;

import java.util.List;

@Controller
@RequestMapping("/procedures")
public class ProceduresResource
{
    private IProcedureService prodecureService;

    @Autowired
    ProceduresResource(IProcedureService prodecureService)
    {
        this.prodecureService = prodecureService;
    }

    @RequestMapping("search/{keyword}")
    public
    @ResponseBody
    List<Procedure> getProcedures(@PathVariable String keyword)
    {
        return prodecureService.getProcedures(keyword);
    }

    @RequestMapping("/{id}")
    public
    @ResponseBody
    Procedure getProcedure(@PathVariable String id)
    {
        return prodecureService.findProcedure(id);
    }
}

