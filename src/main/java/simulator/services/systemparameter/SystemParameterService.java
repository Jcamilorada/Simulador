package simulator.services.systemparameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import simulator.domain.SystemParameter;
import simulator.persistence.SystemParameterRepository;
import simulator.services.systemparameter.ISystemParameterService;

@Component
@Transactional
public class SystemParameterService implements ISystemParameterService
{
    private SystemParameterRepository systemParameterRepository;

    @Autowired
    SystemParameterService(SystemParameterRepository systemParameterRepository)
    {
        this.systemParameterRepository = systemParameterRepository;
    }

    public SystemParameter getSystemParameter(long id)
    {
        return systemParameterRepository.findById(1);
    }
}
