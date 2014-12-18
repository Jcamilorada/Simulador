package simulator.domain.parameter;

import org.springframework.stereotype.Component;
import simulator.domain.common.IBusinessObjectBeanMapper;
import simulator.persistence.parameter.ParameterBean;

@Component
public class ParameterBeanMapper implements IBusinessObjectBeanMapper<ParameterBean, Parameter>
{
    @Override
    public ParameterBean newBusinessObjectBean(Parameter businessObjectDTO)
    {
        ParameterBean parameterBean = new ParameterBean();
        parameterBean.setDescription(businessObjectDTO.getDescription());
        parameterBean.setId(businessObjectDTO.getId());
        parameterBean.setName(businessObjectDTO.getName());
        parameterBean.setValue(businessObjectDTO.getValue());

        return parameterBean;
    }

    @Override
    public Parameter newBusinessObject(ParameterBean businessObject)
    {
        Parameter parameter = new Parameter();
        parameter.setDescription(businessObject.getDescription());
        parameter.setId(businessObject.getId());
        parameter.setName(businessObject.getName());
        parameter.setValue(businessObject.getValue());

        return parameter;
    }
}
