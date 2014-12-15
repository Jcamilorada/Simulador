package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.procedure.Procedure;

import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Procedure Repository. Enable query procedures by code or name.
 * The class implementation is provided by spring data at runtime.
 */
public interface ProcedureRepository extends CrudRepository<Procedure, String>
{
    List<Procedure> findByNameContainingOrCodeContaining(String name, String code);
}
