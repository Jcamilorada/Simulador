package simulator.infusion;

import org.springframework.stereotype.Component;
import simulator.domain.Patient;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;
import simulator.dto.PatientDTO;
import simulator.dto.PumpInfusionDTO;
import simulator.infusion.calculations.SchiderModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfusionMapper
{
    public CalculationRequest newCalculationRequest(final CalculationRequestDTO calculationRequestDTO)
    {
        CalculationRequest request = new CalculationRequest();
        request.setDeltaTime(calculationRequestDTO.getDeltaTime());
        request.setPatient(newPatient(calculationRequestDTO.getPatient()));
        request.setModel(getModel(calculationRequestDTO.getModel(), request.getPatient()));
        request.setInfusionRequestList(getInfusionRequestList(calculationRequestDTO.getPumpInfusion()));

        return request;
    }

    public CalculationResponseDTO newCalculationResponseDTO(final CalculationResponse calculationResponse)
    {
        CalculationResponseDTO responseDTO = new CalculationResponseDTO();
        responseDTO.setErrorCode(calculationResponse.getErrorCode().getValue());
        responseDTO.setInfusionList(getInfusionRequestDTOList(calculationResponse.getInfusionList()));
        responseDTO.setPlasmaConcentrationsData(calculationResponse.getPlasmaConcentrationsData());
        responseDTO.setSiteConcentrationsData(calculationResponse.getSiteConcentrationsData());;

        return responseDTO;
    }

    private IModel getModel(final int model, Patient patient)
    {
        return new SchiderModel(
            patient.getWeight(), patient.getHeight(), patient.getAge());
    }

    private Patient newPatient(final PatientDTO patientDTO)
    {
        Patient patient = new Patient();
        patient.setAge(patientDTO.getAge());
        patient.setHeight(patientDTO.getHeight());
        patient.setWeight(patientDTO.getWeight());
        patient.setGender(Patient.Gender.fromValue(patientDTO.getGender()));

        return  patient;
    }

    private List<PumpInfusion> getInfusionRequestList(List<PumpInfusionDTO> infusionDTOList)
    {
        List<PumpInfusion> infusions = new ArrayList<>(infusionDTOList.size());
        for (PumpInfusionDTO infusionDTO: infusionDTOList)
        {
            infusions.add(new PumpInfusion(infusionDTO.getTime(), infusionDTO.getInfusion()));
        }

        return infusions;
    }

    private List<PumpInfusionDTO> getInfusionRequestDTOList(List<PumpInfusion> infusionList)
    {
        List<PumpInfusionDTO> infusions = new ArrayList<>(infusionList.size());
        for (PumpInfusion infusion: infusionList)
        {
            infusions.add(new PumpInfusionDTO(infusion.getTime(), infusion.getInfusion()));
        }

        return infusions;
    }
}
