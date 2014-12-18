package simulator.domain.procedurestype;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.persistence.proceduretype.ProcedureTypeRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureTypeService implements IProcedureTypeService
{
    private final ProcedureTypeRepository procedureTypeRepository;
    private final ProcedureTypeBeanMapper procedureTypeBeanMapper;

    @Autowired
    ProcedureTypeService(final ProcedureTypeRepository procedureTypeRepository,
                         final ProcedureTypeBeanMapper procedureTypeBeanMapper)
    {
        this.procedureTypeRepository = Preconditions.checkNotNull(procedureTypeRepository, "RecommendationRepository can not be null");
        this.procedureTypeBeanMapper = Preconditions.checkNotNull(procedureTypeBeanMapper, "ObjectMapper can not be null");
    }

    @Override
    public List<ProcedureType> getProcedureTypes()
    {
        return procedureTypeBeanMapper.
            newBusinessObjectList(Lists.newArrayList(procedureTypeRepository.findAll()));
    }
}
