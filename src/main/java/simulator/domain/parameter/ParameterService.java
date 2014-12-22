package simulator.domain.parameter;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.persistence.parameter.ParameterRepository;

import java.util.List;

@Component
@Transactional
public class ParameterService implements IParameterService
{
    private ParameterRepository parameterRepository;
    private final ParameterBeanMapper parameterBeanMapper;

    @Autowired
    ParameterService(ParameterRepository parameterRepository, final ParameterBeanMapper parameterBeanMapper)
    {
        this.parameterRepository = Preconditions.checkNotNull(parameterRepository, "systemParameterRepository cannot be null");
        this.parameterBeanMapper = Preconditions.checkNotNull(parameterBeanMapper, "parameterBeanMapper can not be null");
    }

    @Override
    public Parameter getParameter(final long id)
    {
        return parameterBeanMapper.
            newBusinessObject(Iterables.getFirst(parameterRepository.findById(id), null));
    }
}
