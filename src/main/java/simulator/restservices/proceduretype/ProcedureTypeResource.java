package simulator.restservices.proceduretype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.procedurestype.IProcedureTypeService;

import java.util.List;

@Controller
@RequestMapping("/procedures-types")
public class ProcedureTypeResource
{
    private IProcedureTypeService procedureTypeService;

    private ProcedureTypeMapper procedureTypeMapper;

    @Autowired
    ProcedureTypeResource(
        final IProcedureTypeService procedureTypeService,
        final ProcedureTypeMapper procedureTypeMapper)
    {
        this.procedureTypeService = procedureTypeService;
        this.procedureTypeMapper = procedureTypeMapper;
    }

    @RequestMapping
    public @ResponseBody
    List<ProcedureTypeDTO> getProcedureTypes()
    {
        return procedureTypeMapper.newBusinessObjectDTOList(
            procedureTypeService.getProcedureTypes());
    }
}

