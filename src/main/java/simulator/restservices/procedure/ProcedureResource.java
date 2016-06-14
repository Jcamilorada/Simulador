package simulator.restservices.procedure;

import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.procedure.ProcedureBean;
import simulator.persistence.procedure.ProcedureRepository;

@Controller
@RequestMapping("/procedures")
public class ProcedureResource
{
    private final ProcedureRepository procedureRepository;

    @Autowired
    ProcedureResource(
        final ProcedureRepository procedureRepository)
    {
        this.procedureRepository = Preconditions.checkNotNull(procedureRepository);
    }

    @RequestMapping("search/{keyword}")
    public
    @ResponseBody
    List<ProcedureBean> getProcedures(@PathVariable final String keyword)
    {
        return procedureRepository.findTop10ByNameContainingOrCodeContaining(keyword, keyword);
    }

    @RequestMapping("/{id}")
    public
    @ResponseBody
    ProcedureBean getProcedure(@PathVariable final String id)
    {
        return procedureRepository.findOne(id);
    }
}


