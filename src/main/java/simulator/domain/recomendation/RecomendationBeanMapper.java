package simulator.domain.recomendation;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.recommendation.RecommendationBean;

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
