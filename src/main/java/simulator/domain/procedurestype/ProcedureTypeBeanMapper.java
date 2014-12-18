package simulator.domain.procedurestype;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.proceduretype.ProcedureTypeBean;

@Component
public final class ProcedureTypeBeanMapper extends AbstractBusinessObjectBeanMapper<ProcedureTypeBean, ProcedureType>
{
    @Override
    public ProcedureTypeBean newBusinessObjectBean(ProcedureType businessObjectDTO)
    {
        ProcedureTypeBean procedureTypeBean = new ProcedureTypeBean();
        procedureTypeBean.setId(businessObjectDTO.getId());
        procedureTypeBean.setName(businessObjectDTO.getName());
        procedureTypeBean.setPNR(businessObjectDTO.getPNR());
        procedureTypeBean.setExamples(businessObjectDTO.getExamples());

        return procedureTypeBean;
    }

    @Override
    public ProcedureType newBusinessObject(ProcedureTypeBean businessObject)
    {
        ProcedureType procedureType = new ProcedureType();
        procedureType.setId(businessObject.getId());
        procedureType.setName(businessObject.getName());
        procedureType.setPNR(businessObject.getPNR());
        procedureType.setExamples(businessObject.getExamples());

        return procedureType;
    }
}
