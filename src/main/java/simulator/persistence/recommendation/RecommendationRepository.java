package simulator.persistence.recommendation;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Juan Camilo Rada
 *
 * Recommendation Repository. Enable perform crud operations over recommendations data.
 * The class implementation is provided by spring data at runtime.
 */
public interface RecommendationRepository extends CrudRepository<RecommendationBean, Long>
{
}
