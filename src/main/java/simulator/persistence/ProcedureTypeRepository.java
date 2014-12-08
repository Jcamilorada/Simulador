package simulator.persistence;

import org.springframework.data.repository.CrudRepository;
import simulator.domain.ProcedureType;

public interface ProcedureTypeRepository extends CrudRepository<ProcedureType, Long>
{
}
