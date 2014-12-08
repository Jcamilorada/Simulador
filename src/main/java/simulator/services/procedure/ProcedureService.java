package simulator.services.procedure;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.domain.Procedure;
import simulator.persistence.ProcedureRepository;

import java.util.List;

@Component
@Transactional
public class ProcedureService implements IProcedureService
{
    private final ProcedureRepository procedureRepository;

    @Autowired
    ProcedureService(final ProcedureRepository procedureRepository)
    {
        this.procedureRepository = Preconditions.checkNotNull(procedureRepository, "RecommendationRepository can not be null");
    }

    public List<Procedure> getProcedures(String searchText)
    {
        return procedureRepository.findByNameContainingOrCodeContaining(searchText, searchText);
    }

    @Override
    public Procedure findProcedure(String id)
    {
        return procedureRepository.findOne(id);
    }
}
