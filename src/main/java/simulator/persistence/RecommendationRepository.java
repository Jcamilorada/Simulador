package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.Recommendation;

/**
 * @author Juan Camilo Rada
 *
 * Recommendation Repository. Enable perform crud operations over recommendations data.
 * The class implementation is provided by spring data at runtime.
 */
public interface RecommendationRepository extends CrudRepository<Recommendation, Long>
{
}
