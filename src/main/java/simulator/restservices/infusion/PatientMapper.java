package simulator.restservices.infusion;

import org.springframework.stereotype.Component;
import simulator.domain.infusion.Gender;
import simulator.domain.infusion.Patient;
import simulator.dto.PatientDTO;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;

@Component
class PatientMapper extends AbstractBusinessObjectMapper<Patient, PatientDTO>
{
    @Override
    public Patient newBusinessObject(PatientDTO businessObjectDTO)
    {
        Patient patient = new Patient();
        patient.setAge(businessObjectDTO.getAge());
        patient.setHeight(businessObjectDTO.getHeight());
        patient.setWeight(businessObjectDTO.getWeight());
        patient.setGender(Gender.fromValue(businessObjectDTO.getGender()));

        return  patient;
    }

    @Override
    public PatientDTO newBusinessObjectDTO(Patient businessObject)
    {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setAge(businessObject.getAge());
        patientDTO.setHeight(businessObject.getHeight());
        patientDTO.setWeight(businessObject.getWeight());
        patientDTO.setGender(businessObject.getGender().getValue());

        return  patientDTO;
    }
}
