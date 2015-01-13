package simulator.domain.recomendation;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.persistence.recommendation.RecommendationRepository;

import java.util.List;

@Component
@Transactional
public class RecommendationService implements IRecommendationService
{
    private final RecommendationRepository recommendationRepository;
    private final RecommendationBeanMapper beanMapper;

    @Autowired
    RecommendationService(
        final RecommendationRepository recommendationRepository, final RecommendationBeanMapper recommendationBeanMapper)
    {
        this.recommendationRepository =
            Preconditions.checkNotNull(recommendationRepository, "RecommendationRepository can not be null");
        this.beanMapper =
            Preconditions.checkNotNull(recommendationBeanMapper, "recommendationBeanMapper can not be null");
    }

    @Override
    public List<Recommendation> getRecommendations(int type)
    {
        return beanMapper.newBusinessObjectList(recommendationRepository.findByType(type));
    }
}
