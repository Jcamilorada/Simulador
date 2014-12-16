package simulator.restservices.infusion;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import simulator.domain.common.Patient;
import simulator.dto.PatientDTO;

@Component
public class PatientDTOMapper extends PropertyMap<Patient, PatientDTO>
{
    @Override
    protected void configure()
    {
        map().setGender(source.getGender().getValue());
    }
}
