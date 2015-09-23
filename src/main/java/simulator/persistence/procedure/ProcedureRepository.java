package simulator.persistence.procedure;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.procedure.Procedure;

import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Procedure Repository. Enable query procedures by code or name.
 * The class implementation is provided by spring data at runtime.
 */
public interface ProcedureRepository extends CrudRepository<ProcedureBean, String>
{
    List<ProcedureBean> findTop10ByNameContainingOrCodeContaining(String name, String code);
}
