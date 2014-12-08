package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import simulator.domain.Procedure;

import java.util.List;

public interface ProcedureRepository extends CrudRepository<Procedure, String>
{
    List<Procedure> findByNameContainingOrCodeContaining(String name, String code);
}
