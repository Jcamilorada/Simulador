package simulator.persistence.solution;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Juan Camilo Rada
 *
 * Solution Repository. Enable perform crud operations over solution data.
 * The class implementation is provided by spring data at runtime.
 */
public interface SolutionRepository extends CrudRepository<SolutionBean, Long>
{
}
