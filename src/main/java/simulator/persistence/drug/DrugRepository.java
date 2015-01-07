package simulator.persistence.drug;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRepository extends CrudRepository<DrugBean, Long>
{
    List<DrugBean> findByDrugType(int drugType);
}
