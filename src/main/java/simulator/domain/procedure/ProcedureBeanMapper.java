package simulator.domain.procedure;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.procedure.ProcedureBean;

@Component
public class ProcedureBeanMapper extends AbstractBusinessObjectBeanMapper<ProcedureBean, Procedure>
{
    @Override
    public ProcedureBean newBusinessObjectBean(final Procedure businessObjectDTO)
    {
        ProcedureBean procedureBean = new ProcedureBean();
        procedureBean.setName(businessObjectDTO.getName());
        procedureBean.setCode(businessObjectDTO.getCode());

        return procedureBean;
    }

    @Override
    public Procedure newBusinessObject(final ProcedureBean businessObject)
    {
        Procedure procedure = new Procedure();
        procedure.setName(businessObject.getName());
        procedure.setCode(businessObject.getCode());

        return procedure;
    }
}
