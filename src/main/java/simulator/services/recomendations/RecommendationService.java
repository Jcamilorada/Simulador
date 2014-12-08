package simulator.services.recomendations;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.domain.Recommendation;
import simulator.persistence.RecommendationRepository;

import java.util.List;

@Component
@Transactional
public class RecommendationService implements IRecommendationService
{
    private final RecommendationRepository recomendationRepository;

    @Autowired
    RecommendationService(final RecommendationRepository recomendationRepository)
    {
        this.recomendationRepository = Preconditions.checkNotNull(recomendationRepository, "RecommendationRepository can not be null");
    }

    public List<Recommendation> getRecomendations()
    {
        return Lists.newArrayList(recomendationRepository.findAll().iterator());
    }
}
