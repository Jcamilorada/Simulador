package simulator.services.systemparameter;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.domain.SystemParameter;
import simulator.persistence.SystemParameterRepository;

@Component
@Transactional
public class SystemParameterService implements ISystemParameterService
{
    private SystemParameterRepository systemParameterRepository;

    @Autowired
    SystemParameterService(SystemParameterRepository systemParameterRepository)
    {
        this.systemParameterRepository = Preconditions.checkNotNull(systemParameterRepository, "systemParameterRepository cannot be null");
    }

    public SystemParameter getSystemParameter(final long id)
    {
        return systemParameterRepository.findById(1);
    }
}
