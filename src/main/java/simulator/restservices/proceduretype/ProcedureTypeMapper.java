package simulator.restservices.proceduretype;

import org.springframework.stereotype.Component;
import simulator.domain.procedurestype.ProcedureType;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code ProcedureType} and  {@code ProcedureTypeDTO} mapper.
 */
@Component
public class ProcedureTypeMapper extends AbstractBusinessObjectMapper<ProcedureType, ProcedureTypeDTO>
{
    @Override
    public ProcedureType newBusinessObject(final ProcedureTypeDTO businessObjectDTO)
    {
        ProcedureType procedureType = new ProcedureType();
        procedureType.setName(businessObjectDTO.getName());
        procedureType.setId(businessObjectDTO.getId());
        procedureType.setRemi(businessObjectDTO.getRemi());
        procedureType.setProp(businessObjectDTO.getProp());
        procedureType.setExamples(businessObjectDTO.getExamples());

        return  procedureType;
    }

    @Override
    public ProcedureTypeDTO newBusinessObjectDTO(final ProcedureType businessObject)
    {
        ProcedureTypeDTO ProcedureTypeDTO = new ProcedureTypeDTO();
        ProcedureTypeDTO.setName(businessObject.getName());
        ProcedureTypeDTO.setId(businessObject.getId());
        ProcedureTypeDTO.setRemi(businessObject.getRemi());
        ProcedureTypeDTO.setProp(businessObject.getProp());
        ProcedureTypeDTO.setExamples(businessObject.getExamples());

        return  ProcedureTypeDTO;
    }
}
