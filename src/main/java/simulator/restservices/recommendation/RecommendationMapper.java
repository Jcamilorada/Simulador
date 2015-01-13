package simulator.restservices.recommendation;

import org.springframework.stereotype.Component;
import simulator.domain.recomendation.RecommendationType;
import simulator.domain.recomendation.Recommendation;
import simulator.domain.recomendation.SentenceType;
import simulator.restservices.common.AbstractBusinessObjectMapper;

@Component
class RecommendationMapper extends AbstractBusinessObjectMapper<Recommendation, RecommendationDTO>
{
    @Override
    public Recommendation newBusinessObject(RecommendationDTO businessObjectDTO)
    {
        Recommendation recommendation = new Recommendation();
        recommendation.setDescription(businessObjectDTO.getDescription());
        recommendation.setId(businessObjectDTO.getId());
        recommendation.setRecommendationType(RecommendationType.fromValue(businessObjectDTO.getType()));
        recommendation.setAlternatives(businessObjectDTO.getAlternatives());
        recommendation.setSentenceType(SentenceType.fromValue(businessObjectDTO.getSentenceType()));

        return  recommendation;
    }

    @Override
    public RecommendationDTO newBusinessObjectDTO(Recommendation businessObject)
    {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setDescription(businessObject.getDescription());
        recommendationDTO.setId(businessObject.getId());
        recommendationDTO.setType(businessObject.getRecommendationType().getValue());
        recommendationDTO.setAlternatives(businessObject.getAlternatives());
        recommendationDTO.setSentenceType(businessObject.getSentenceType().getValue());

        return  recommendationDTO;
    }
}
