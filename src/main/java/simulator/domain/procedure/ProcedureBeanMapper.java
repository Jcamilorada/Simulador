package simulator.domain.procedure;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.procedure.ProcedureBean;

@Component
public class ProcedureBeanMapper extends AbstractBusinessObjectBeanMapper<ProcedureBean, Procedure>
{
    @Override
    public ProcedureBean newBusinessObjectBean(final Procedure businessObject)
    {
        ProcedureBean procedureBean = new ProcedureBean();
        procedureBean.setName(businessObject.getName());
        procedureBean.setCode(businessObject.getCode());

        return procedureBean;
    }

    @Override
    public Procedure newBusinessObject(final ProcedureBean businessObjectBean)
    {
        Procedure procedure = new Procedure();
        procedure.setName(businessObjectBean.getName());
        procedure.setCode(businessObjectBean.getCode());

        return procedure;
    }
}
