package simulator.domain.induction;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.indution.InductionMethodBean;

@Component
public class InductionMethodBeanMapper extends AbstractBusinessObjectBeanMapper<InductionMethodBean, InductionMethod>
{
    @Override
    public InductionMethodBean newBusinessObjectBean(InductionMethod businessObjectDTO)
    {
        InductionMethodBean inductionMethodBean = new InductionMethodBean();
        inductionMethodBean.setId(businessObjectDTO.getId());
        inductionMethodBean.setName(businessObjectDTO.getName());
        inductionMethodBean.setPnr(businessObjectDTO.getPnr());

        return inductionMethodBean;
    }

    @Override
    public InductionMethod newBusinessObject(InductionMethodBean businessObject)
    {
        InductionMethod inductionMethod = new InductionMethod();
        inductionMethod.setPnr(businessObject.getPnr());
        inductionMethod.setName(businessObject.getName());
        inductionMethod.setId(businessObject.getId());

        return inductionMethod;
    }
}
