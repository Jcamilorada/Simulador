package simulator.domain.recomendations;

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
    private final RecommendationRepository recomendationRepository;
    private final RecomendationBeanMapper beanMapper;

    @Autowired
    RecommendationService(
        final RecommendationRepository recomendationRepository, final RecomendationBeanMapper objectMapper)
    {
        this.recomendationRepository =
            Preconditions.checkNotNull(recomendationRepository, "RecommendationRepository can not be null");
        this.beanMapper =
            Preconditions.checkNotNull(objectMapper, "beanMapper can not be null");
    }

    @Override
    public List<Recommendation> getRecomendations()
    {
        return beanMapper.newBusinessObjectList(
            Lists.newArrayList(recomendationRepository.findAll()));
    }
}
