package simulator.domain.procedurestypes;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.common.ObjectMapper;
import simulator.persistence.proceduretype.ProcedureTypeRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureTypeService implements IProcedureTypeService
{
    private final ProcedureTypeRepository procedureTypeRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    ProcedureTypeService(final ProcedureTypeRepository procedureTypeRepository,
                         final ObjectMapper objectMapper)
    {
        this.procedureTypeRepository = Preconditions.checkNotNull(procedureTypeRepository, "RecommendationRepository can not be null");
        this.objectMapper = Preconditions.checkNotNull(objectMapper, "ObjectMapper can not be null");
    }

    @Override
    public List<ProcedureType> getProcedureTypes()
    {
        return objectMapper.mapList(
            Lists.newArrayList(procedureTypeRepository.findAll()),
            ProcedureType.class);
    }
}
