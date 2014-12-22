package simulator.restservices.parameter;

import org.springframework.stereotype.Component;
import simulator.domain.parameter.Parameter;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code Parameter} and  {@code ParameterDTO} mapper.
 */
@Component
class ParameterMapper extends AbstractBusinessObjectMapper<Parameter, ParameterDTO>
{

    @Override
    public Parameter newBusinessObject(final ParameterDTO businessObjectDTO)
    {
        Parameter parameter = new Parameter();
        parameter.setValue(businessObjectDTO.getValue());
        parameter.setId(businessObjectDTO.getId());
        parameter.setName(businessObjectDTO.getName());

        return parameter;
    }

    @Override
    public ParameterDTO newBusinessObjectDTO(final Parameter businessObject)
    {
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setValue(businessObject.getValue());
        parameterDTO.setId(businessObject.getId());
        parameterDTO.setName(businessObject.getName());

        return parameterDTO;
    }
}
