package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.procedurestypes.ProcedureType;

/**
 * @author Juan Camilo Rada
 *
 * Procedure Repository. Enable perform crud operations over procedures type.
 * The class implementation is provided by spring data at runtime.
 */
public interface ProcedureTypeRepository extends CrudRepository<ProcedureType, Long>
{
}
