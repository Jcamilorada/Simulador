package simulator.domain.procedure;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.common.ObjectMapper;
import simulator.persistence.procedure.ProcedureRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureService implements IProcedureService
{
    private final ProcedureRepository procedureRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    ProcedureService(
        final ProcedureRepository procedureRepository,
        final ObjectMapper objectMapper)
    {
        this.procedureRepository =
            Preconditions.checkNotNull(procedureRepository, "RecommendationRepository can not be null");
        this.objectMapper =
            Preconditions.checkNotNull(objectMapper, "ObjectMapper can not be null");
    }

    @Override
    public List<Procedure> getProcedures(final String searchText)
    {
        return objectMapper.mapList(
            procedureRepository.findByNameContainingOrCodeContaining(searchText, searchText), Procedure.class);
    }

    @Override
    public Procedure findProcedure(final String id)
    {
        return objectMapper.map(procedureRepository.findOne(id), Procedure.class);
    }
}
