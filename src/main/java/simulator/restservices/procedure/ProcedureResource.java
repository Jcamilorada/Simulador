package simulator.restservices.procedure;

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
public class ProcedureResource
{
    private final IProcedureService prodecureService;
    private final ProcedureMapper procedureMapper;

    @Autowired
    ProcedureResource(
        IProcedureService prodecureService, ProcedureMapper procedureMapper)
    {
        this.prodecureService = prodecureService;
        this.procedureMapper = procedureMapper;
    }

    @RequestMapping("search/{keyword}")
    public
    @ResponseBody
    List<ProcedureDTO> getProcedures(@PathVariable final String keyword)
    {
        return procedureMapper.newBusinessObjectDTOList(
            prodecureService.getProcedures(keyword));
    }

    @RequestMapping("/{id}")
    public
    @ResponseBody
    ProcedureDTO getProcedure(@PathVariable final String id)
    {
        return procedureMapper.newBusinessObjectDTO(
            prodecureService.findProcedure(id));
    }
}


