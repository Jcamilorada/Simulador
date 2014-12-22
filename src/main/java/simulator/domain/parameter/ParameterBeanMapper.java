package simulator.domain.parameter;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.parameter.ParameterBean;

@Component
public class ParameterBeanMapper extends AbstractBusinessObjectBeanMapper<ParameterBean, Parameter>
{
    @Override
    public ParameterBean newBusinessObjectBean(Parameter businessObjectDTO)
    {
        ParameterBean parameterBean = new ParameterBean();
        parameterBean.setName(businessObjectDTO.getName());
        parameterBean.setId(businessObjectDTO.getId());
        parameterBean.setValue(businessObjectDTO.getValue());

        return parameterBean;
    }

    @Override
    public Parameter newBusinessObject(ParameterBean businessObject)
    {
        Parameter parameter = new Parameter();
        parameter.setName(businessObject.getName());
        parameter.setId(businessObject.getId());
        parameter.setValue(businessObject.getValue());

        return parameter;
    }
}
