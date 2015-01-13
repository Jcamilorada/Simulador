package simulator.domain.parameter;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.parameter.ParameterBean;

@Component
public class ParameterBeanMapper extends AbstractBusinessObjectBeanMapper<ParameterBean, Parameter>
{
    @Override
    public ParameterBean newBusinessObjectBean(Parameter businessObject)
    {
        ParameterBean parameterBean = new ParameterBean();
        parameterBean.setName(businessObject.getName());
        parameterBean.setId(businessObject.getId());
        parameterBean.setValue(businessObject.getValue());

        return parameterBean;
    }

    @Override
    public Parameter newBusinessObject(ParameterBean businessObjectBean)
    {
        Parameter parameter = new Parameter();
        parameter.setName(businessObjectBean.getName());
        parameter.setId(businessObjectBean.getId());
        parameter.setValue(businessObjectBean.getValue());

        return parameter;
    }
}
