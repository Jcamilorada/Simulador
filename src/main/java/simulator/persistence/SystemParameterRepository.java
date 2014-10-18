package simulator.persistence;

import org.springframework.data.repository.Repository;
import simulator.domain.SystemParameter;

public interface SystemParameterRepository extends Repository<SystemParameter, Long>
{
    SystemParameter findById(long id);
}
