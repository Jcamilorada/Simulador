package simulator.restservices.proceduretype;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.proceduretype.ProcedureTypeBean;
import simulator.persistence.proceduretype.ProcedureTypeRepository;

@Controller
@RequestMapping("/procedures-types")
public class ProcedureTypeResource
{
    private final ProcedureTypeRepository procedureTypeRepository;

    @Autowired
    ProcedureTypeResource(ProcedureTypeRepository procedureTypeRepository)
    {
        this.procedureTypeRepository = Preconditions.checkNotNull(procedureTypeRepository);
    }

    @RequestMapping
    public @ResponseBody
    List<ProcedureTypeBean> getProcedureTypes()
    {
        return Lists.newArrayList(procedureTypeRepository.findAll());
    }
}

