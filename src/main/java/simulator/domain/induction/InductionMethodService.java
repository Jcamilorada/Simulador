package simulator.domain.induction;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.persistence.indution.InductionMethodRepository;

import java.util.List;

@Component
public class InductionMethodService
{
    private final InductionMethodRepository inductionMethodRepository;
    private final InductionMethodBeanMapper beanMapper;

    @Autowired
    InductionMethodService(final InductionMethodRepository inductionMethodRepository, final InductionMethodBeanMapper beanMapper)
    {
        this.inductionMethodRepository = inductionMethodRepository;
        this.beanMapper = beanMapper;
    }


    public List<InductionMethod> getInductionMethods()
    {
        return beanMapper.newBusinessObjectList(
            Lists.newArrayList(inductionMethodRepository.findAll()));
    }
}
