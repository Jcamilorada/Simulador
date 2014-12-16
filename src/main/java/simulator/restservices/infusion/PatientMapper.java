package simulator.restservices.infusion;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import simulator.domain.common.Gender;
import simulator.domain.common.Patient;
import simulator.dto.PatientDTO;

@Component
public class PatientMapper extends PropertyMap<PatientDTO, Patient>
{
    @Override
    protected void configure()
    {
        map().setGender(Gender.fromValue(source.getGender()));
    }
}
