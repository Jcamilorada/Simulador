package simulator.domain.solution;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.persistence.solution.SolutionRepository;

import java.util.List;

@Component
public class SolutionService implements ISolutionService
{
    private final SolutionRepository solutionRepository;
    private final SolutionBeanMapper solutionBeanMapper;

    @Autowired
    SolutionService(final SolutionRepository solutionRepository, final SolutionBeanMapper solutionBeanMapper)
    {
        this.solutionRepository = Preconditions.checkNotNull(solutionRepository);
        this.solutionBeanMapper = Preconditions.checkNotNull(solutionBeanMapper);
    }

    public List<Solution> findAll()
    {
        return solutionBeanMapper.newBusinessObjectList(solutionRepository.findAll());
    }
}
