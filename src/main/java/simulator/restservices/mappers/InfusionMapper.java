package simulator.restservices.mappers;

import org.springframework.stereotype.Component;
import simulator.domain.common.Gender;
import simulator.domain.common.Patient;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.CalculationResponse;
import simulator.domain.infusion.PumpInfusion;
import simulator.domain.infusion.model.Model;
import simulator.domain.infusion.model.ModelFactory;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.CalculationResponseDTO;
import simulator.dto.PatientDTO;
import simulator.dto.PumpInfusionDTO;
import simulator.domain.infusion.model.IModel;
import simulator.domain.infusion.model.SchiderModel;

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
        request.setModel(Model.fromValue(calculationRequestDTO.getModel()));
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

    public Patient newPatient(final PatientDTO patientDTO)
    {
        Patient patient = new Patient();
        patient.setAge(patientDTO.getAge());
        patient.setHeight(patientDTO.getHeight());
        patient.setWeight(patientDTO.getWeight());
        patient.setGender(Gender.fromValue(patientDTO.getGender()));

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
