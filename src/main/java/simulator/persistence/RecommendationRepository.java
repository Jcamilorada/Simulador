package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.Recommendation;

public interface RecommendationRepository extends CrudRepository<Recommendation, Long>
{
}
