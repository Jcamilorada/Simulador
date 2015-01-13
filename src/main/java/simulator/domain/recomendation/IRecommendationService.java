package simulator.domain.recomendation;

import java.util.List;

public interface IRecommendationService
{
    public List<Recommendation> getRecommendations(int type);
}
