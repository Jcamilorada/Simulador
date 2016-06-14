package simulator.persistence.drug;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRepository extends CrudRepository<Drug, Long>
{
    List<Drug> findByDrugType(int drugType);
}
