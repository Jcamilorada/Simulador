package simulator.domain.procedurestype;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.proceduretype.ProcedureTypeBean;

@Component
public final class ProcedureTypeBeanMapper extends AbstractBusinessObjectBeanMapper<ProcedureTypeBean, ProcedureType>
{
    @Override
    public ProcedureTypeBean newBusinessObjectBean(ProcedureType businessObject)
    {
        ProcedureTypeBean procedureTypeBean = new ProcedureTypeBean();
        procedureTypeBean.setId(businessObject.getId());
        procedureTypeBean.setName(businessObject.getName());
        procedureTypeBean.setPNR(businessObject.getPNR());
        procedureTypeBean.setExamples(businessObject.getExamples());

        return procedureTypeBean;
    }

    @Override
    public ProcedureType newBusinessObject(ProcedureTypeBean businessObjectBean)
    {
        ProcedureType procedureType = new ProcedureType();
        procedureType.setId(businessObjectBean.getId());
        procedureType.setName(businessObjectBean.getName());
        procedureType.setPNR(businessObjectBean.getPNR());
        procedureType.setExamples(businessObjectBean.getExamples());

        return procedureType;
    }
}
