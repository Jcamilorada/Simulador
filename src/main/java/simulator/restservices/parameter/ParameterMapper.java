package simulator.restservices.parameter;

import org.springframework.stereotype.Component;
import simulator.domain.parameter.Parameter;
import simulator.domain.recomendations.Recommendation;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;
import simulator.restservices.recommendation.RecommendationDTO;

@Component
class ParameterMapper extends AbstractBusinessObjectMapper<Parameter, ParameterDTO>
{

    @Override
    public Parameter newBusinessObject(ParameterDTO businessObjectDTO)
    {
        Parameter parameter = new Parameter();
        parameter.setName(businessObjectDTO.getName());
        parameter.setValue(businessObjectDTO.getValue());
        parameter.setId(businessObjectDTO.getId());
        parameter.setDescription(businessObjectDTO.getDescription());

        return parameter;
    }

    @Override
    public ParameterDTO newBusinessObjectDTO(Parameter businessObject)
    {
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setName(businessObject.getName());
        parameterDTO.setValue(businessObject.getValue());
        parameterDTO.setId(businessObject.getId());
        parameterDTO.setDescription(businessObject.getDescription());

        return parameterDTO;
    }
}
