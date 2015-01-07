package simulator.domain.drug;

import java.util.List;

public interface IDrugService
{
    public List<Drug> findAllByType(DrugType type);
}
