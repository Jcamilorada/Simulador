package simulator.domain.systemparameter;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.common.ObjectMapper;
import simulator.persistence.parameter.SystemParameterRepository;

@Component
@Transactional
public class SystemParameterService implements ISystemParameterService
{
    private SystemParameterRepository systemParameterRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    SystemParameterService(SystemParameterRepository systemParameterRepository, final ObjectMapper objectMapper)
    {
        this.systemParameterRepository = Preconditions.checkNotNull(systemParameterRepository, "systemParameterRepository cannot be null");
        this.objectMapper = Preconditions.checkNotNull(objectMapper, "objectMapper can not be null");
    }

    public SystemParameter getSystemParameter(final long id)
    {
        return objectMapper.map(
            systemParameterRepository.findById(id), SystemParameter.class);
    }
}
