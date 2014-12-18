package simulator.restservices.recommendation;

import org.springframework.stereotype.Component;
import simulator.domain.recomendations.Recommendation;
import simulator.persistence.recommendation.RecommendationBean;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;

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
