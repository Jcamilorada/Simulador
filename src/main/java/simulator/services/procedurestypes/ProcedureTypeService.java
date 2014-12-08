package simulator.services.procedurestypes;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.domain.ProcedureType;
import simulator.persistence.ProcedureTypeRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureTypeService implements IProcedureTypeService
{
    private final ProcedureTypeRepository procedureTypeRepository;

    @Autowired
    ProcedureTypeService(final ProcedureTypeRepository procedureTypeRepository)
    {
        this.procedureTypeRepository = Preconditions.checkNotNull(procedureTypeRepository, "RecommendationRepository can not be null");
    }

    public List<ProcedureType> getProcedureTypes()
    {
        return Lists.newArrayList(procedureTypeRepository.findAll());
    }
}
