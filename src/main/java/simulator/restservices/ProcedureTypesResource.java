package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.ProcedureType;
import simulator.services.procedurestypes.IProcedureTypeService;

import java.util.List;

@Controller
@RequestMapping("/procedures-types")
public class ProcedureTypesResource
{
    private IProcedureTypeService procedureTypeService;

    @Autowired
    ProcedureTypesResource(IProcedureTypeService procedureTypeService)
    {
        this.procedureTypeService = procedureTypeService;
    }

    @RequestMapping
    public @ResponseBody
    List<ProcedureType> getProcedureTypes()
    {
        return procedureTypeService.getProcedureTypes();
    }
}

