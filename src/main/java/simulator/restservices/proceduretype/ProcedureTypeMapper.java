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
        procedureType.setExamples(businessObjectDTO.getExamples());
        procedureType.setPNR(businessObjectDTO.getPNR());

        return  procedureType;
    }

    @Override
    public ProcedureTypeDTO newBusinessObjectDTO(final ProcedureType businessObject)
    {
        ProcedureTypeDTO ProcedureTypeDTO = new ProcedureTypeDTO();
        ProcedureTypeDTO.setName(businessObject.getName());
        ProcedureTypeDTO.setId(businessObject.getId());
        ProcedureTypeDTO.setExamples(businessObject.getExamples());
        ProcedureTypeDTO.setPNR(businessObject.getPNR());

        return  ProcedureTypeDTO;
    }
}
