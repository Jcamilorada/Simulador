package simulator.persistence.parameter;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * System Repository. Enable perform crud operations over system parameter data.
 * The class implementation is provided by spring data at runtime.
 */
public interface ParameterRepository extends CrudRepository<ParameterBean, Long>
{
    List<ParameterBean> findById(long id);
}
