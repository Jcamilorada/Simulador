package simulator.persistence.proceduretype;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Juan Camilo Rada
 *
 * Procedure Repository. Enable perform crud operations over procedures type.
 * The class implementation is provided by spring data at runtime.
 */
public interface ProcedureTypeRepository extends CrudRepository<ProcedureTypeBean, Long>
{
}
