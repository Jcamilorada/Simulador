package simulator.persistence.parameter;

import org.springframework.data.repository.Repository;

/**
 * @author Juan Camilo Rada
 *
 * System Repository. Enable perform crud operations over system parameter data.
 * The class implementation is provided by spring data at runtime.
 */
public interface ParameterRepository extends Repository<ParameterBean, Long>
{
    ParameterBean findById(long id);
}
