package simulator.persistence.drug;

import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<DrugBean, Long>
{
}
