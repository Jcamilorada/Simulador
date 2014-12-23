package simulator.restservices.recommendation;

import org.springframework.stereotype.Component;
import simulator.domain.recomendation.Recommendation;
import simulator.restservices.common.AbstractBusinessObjectMapper;

@Component
class RecomendationMapper extends AbstractBusinessObjectMapper<Recommendation, RecommendationDTO>
{
    @Override
    public Recommendation newBusinessObject(RecommendationDTO businessObjectDTO)
    {
        Recommendation recommendation = new Recommendation();
        recommendation.setDescription(businessObjectDTO.getDescription());
        recommendation.setId(businessObjectDTO.getId());

        return  recommendation;
    }

    @Override
    public RecommendationDTO newBusinessObjectDTO(Recommendation businessObject)
    {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setDescription(businessObject.getDescription());
        recommendationDTO.setId(businessObject.getId());

        return  recommendationDTO;
    }
}
