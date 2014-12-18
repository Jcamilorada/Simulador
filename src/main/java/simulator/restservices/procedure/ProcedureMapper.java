package simulator.restservices.procedure;

import org.springframework.stereotype.Component;
import simulator.domain.procedure.Procedure;
import simulator.restservices.common.AbstractBusinessObjectMapper;

@Component
public class ProcedureMapper extends AbstractBusinessObjectMapper<Procedure, ProcedureDTO>
{
    @Override
    public Procedure newBusinessObject(ProcedureDTO businessObjectDTO)
    {
        Procedure procedure = new Procedure();
        procedure.setName(businessObjectDTO.getName());
        procedure.setCode(businessObjectDTO.getCode());

        return  procedure;
    }

    @Override
    public ProcedureDTO newBusinessObjectDTO(Procedure businessObject)
    {
        ProcedureDTO procedureDTO = new ProcedureDTO();
        procedureDTO.setName(businessObject.getName());
        procedureDTO.setCode(businessObject.getCode());

        return  procedureDTO;
    }
}
