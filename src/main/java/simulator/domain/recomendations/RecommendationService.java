package simulator.domain.recomendations;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.common.ObjectMapper;
import simulator.persistence.recommendation.RecommendationRepository;

import java.util.List;

@Component
@Transactional
public class RecommendationService implements IRecommendationService
{
    private final RecommendationRepository recomendationRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    RecommendationService(
        final RecommendationRepository recomendationRepository, final ObjectMapper objectMapper)
    {
        this.recomendationRepository = Preconditions.checkNotNull(recomendationRepository, "RecommendationRepository can not be null");
        this.objectMapper = Preconditions.checkNotNull(objectMapper, "objectMapper can not be null");
    }

    @Override
    public List<Recommendation> getRecomendations()
    {
        return  objectMapper.mapList(
            Lists.newArrayList(recomendationRepository.findAll().iterator()),
            Recommendation.class);
    }
}
