package simulator.services.recomendations;

import simulator.domain.Recommendation;

import java.util.List;

public interface IRecommendationService
{
    public List<Recommendation> getRecomendations();
}
