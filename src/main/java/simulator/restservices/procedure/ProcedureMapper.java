package simulator.restservices.procedure;

import org.springframework.stereotype.Component;
import simulator.domain.procedure.Procedure;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code Procedure} and  {@code ProcedureDTO} mapper.
 */
@Component
public class ProcedureMapper extends AbstractBusinessObjectMapper<Procedure, ProcedureDTO>
{
    @Override
    public Procedure newBusinessObject(final ProcedureDTO businessObjectDTO)
    {
        Procedure procedure = new Procedure();
        procedure.setName(businessObjectDTO.getName());
        procedure.setCode(businessObjectDTO.getCode());

        return  procedure;
    }

    @Override
    public ProcedureDTO newBusinessObjectDTO(final Procedure businessObject)
    {
        ProcedureDTO procedureDTO = new ProcedureDTO();
        procedureDTO.setName(businessObject.getName());
        procedureDTO.setCode(businessObject.getCode());

        return  procedureDTO;
    }
}
