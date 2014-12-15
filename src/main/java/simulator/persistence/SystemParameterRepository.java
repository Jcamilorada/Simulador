package simulator.persistence;

import org.springframework.data.repository.Repository;
import simulator.domain.systemparameter.SystemParameter;

/**
 * @author Juan Camilo Rada
 *
 * System Repository. Enable perform crud operations over system parameter data.
 * The class implementation is provided by spring data at runtime.
 */
public interface SystemParameterRepository extends Repository<SystemParameter, Long>
{
    SystemParameter findById(long id);
}
