package simulator.domain.recomendations;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.domain.common.IBusinessObjectBeanMapper;
import simulator.persistence.recommendation.RecommendationBean;
import simulator.restservices.common.IBusinessObjectMapper;
import simulator.restservices.recommendation.RecommendationDTO;

@Component
class RecomendationBeanMapper extends AbstractBusinessObjectBeanMapper<RecommendationBean, Recommendation>
{
    @Override
    public RecommendationBean newBusinessObjectBean(Recommendation businessObjectDTO)
    {
        RecommendationBean recommendationBean = new RecommendationBean();
        recommendationBean.setDescription(businessObjectDTO.getDescription());
        recommendationBean.setId(businessObjectDTO.getId());

        return  recommendationBean;
    }

    @Override
    public Recommendation newBusinessObject(RecommendationBean businessObject)
    {
        Recommendation recommendation = new Recommendation();
        recommendation.setDescription(businessObject.getDescription());
        recommendation.setId(businessObject.getId());

        return  recommendation;
    }
}
