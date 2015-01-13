package simulator.domain.recomendation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import simulator.common.util.StringUtil;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.recommendation.RecommendationBean;

@Component
class RecommendationBeanMapper extends AbstractBusinessObjectBeanMapper<RecommendationBean, Recommendation>
{
    public static final String ALTERNATIVES_SEPARATOR = "#";

    @Override
    public RecommendationBean newBusinessObjectBean(final Recommendation businessObject)
    {
        RecommendationBean recommendationBean = new RecommendationBean();
        recommendationBean.setDescription(businessObject.getDescription());
        recommendationBean.setId(businessObject.getId());
        recommendationBean.setType(businessObject.getRecommendationType().getValue());
        recommendationBean.setSentenceType(businessObject.getSentenceType().getValue());
        recommendationBean.setAlternatives(
            StringUtils.join(businessObject.getAlternatives(), ALTERNATIVES_SEPARATOR));

        return  recommendationBean;
    }

    @Override
    public Recommendation newBusinessObject(final RecommendationBean businessObjectBean)
    {
        Recommendation recommendation = new Recommendation();
        recommendation.setDescription(businessObjectBean.getDescription());
        recommendation.setId(businessObjectBean.getId());
        recommendation.setRecommendationType(RecommendationType.fromValue(businessObjectBean.getType()));
        recommendation.setAlternatives(
            StringUtil.getStringList(businessObjectBean.getAlternatives(), ALTERNATIVES_SEPARATOR));

        recommendation.setSentenceType(SentenceType.fromValue(businessObjectBean.getSentenceType()));

        return  recommendation;
    }
}
