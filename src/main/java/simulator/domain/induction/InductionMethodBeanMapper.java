package simulator.domain.induction;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.indution.InductionMethodBean;

@Component
public class InductionMethodBeanMapper extends AbstractBusinessObjectBeanMapper<InductionMethodBean, InductionMethod>
{
    @Override
    public InductionMethodBean newBusinessObjectBean(InductionMethod businessObject)
    {
        InductionMethodBean inductionMethodBean = new InductionMethodBean();
        inductionMethodBean.setId(businessObject.getId());
        inductionMethodBean.setName(businessObject.getName());
        inductionMethodBean.setPnr(businessObject.getPnr());

        return inductionMethodBean;
    }

    @Override
    public InductionMethod newBusinessObject(InductionMethodBean businessObjectBean)
    {
        InductionMethod inductionMethod = new InductionMethod();
        inductionMethod.setPnr(businessObjectBean.getPnr());
        inductionMethod.setName(businessObjectBean.getName());
        inductionMethod.setId(businessObjectBean.getId());

        return inductionMethod;
    }
}
