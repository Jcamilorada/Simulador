package simulator.domain.drug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.persistence.drug.DrugRepository;

import java.util.List;

@Component
public class DrugService implements IDrugService
{
    private final DrugRepository drugRepository;
    private final DrugBeanMapper beanMapper;

    @Autowired
    DrugService(final DrugRepository drugRepository, final DrugBeanMapper beanMapper)
    {
        this.drugRepository = drugRepository;
        this.beanMapper = beanMapper;
    }

    @Override
    public List<Drug> findAll()
    {
        return beanMapper.newBusinessObjectList(drugRepository.findAll());
    }
}
