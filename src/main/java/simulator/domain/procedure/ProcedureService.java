package simulator.domain.procedure;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.persistence.procedure.ProcedureRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureService implements IProcedureService
{
    private final ProcedureRepository procedureRepository;
    private final ProcedureBeanMapper procedureBeanMapper;

    @Autowired
    ProcedureService(
        final ProcedureRepository procedureRepository,
        final ProcedureBeanMapper procedureBeanMapper)
    {
        this.procedureRepository =
            Preconditions.checkNotNull(procedureRepository, "RecommendationRepository can not be null");
        this.procedureBeanMapper =
            Preconditions.checkNotNull(procedureBeanMapper, "ObjectMapper can not be null");
    }

    @Override
    public List<Procedure> getProcedures(final String searchText)
    {
        return procedureBeanMapper.newBusinessObjectList(
            procedureRepository.findByNameContainingOrCodeContaining(searchText, searchText));
    }

    @Override
    public Procedure findProcedure(final String id)
    {
        return procedureBeanMapper.newBusinessObject(procedureRepository.findOne(id));
    }
}
