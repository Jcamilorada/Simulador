package simulator.restservices.infusion;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.model.Model;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code CalculationRequest} and  {@code CalculationRequestDTO} mapper.
 */
@Component
class CalculationRequestMapper extends AbstractBusinessObjectMapper<CalculationRequest, CalculationRequestDTO>
{
    private final PatientMapper patientMapper;
    private final PumpInfusionMapper pumpInfusionMapper;

    @Autowired
    CalculationRequestMapper(final PatientMapper patientMapper,
                             final PumpInfusionMapper pumpInfusionMapper)
    {
        this.patientMapper = Preconditions.checkNotNull(patientMapper);
        this.pumpInfusionMapper = Preconditions.checkNotNull(pumpInfusionMapper);
    }

    @Override
    public CalculationRequest newBusinessObject(final CalculationRequestDTO businessObjectDTO)
    {
        CalculationRequest calculationRequest = new CalculationRequest();
        calculationRequest.setPatient(patientMapper.newBusinessObject(businessObjectDTO.getPatient()));
        calculationRequest.setDeltaTime(businessObjectDTO.getDeltaTime());
        calculationRequest.setModel(Model.fromValue(businessObjectDTO.getModel()));

        calculationRequest.setInfusionRequestList(
            pumpInfusionMapper.newBusinessObjectList(businessObjectDTO.getPumpInfusion()));

        return  calculationRequest;
    }

    @Override
    public CalculationRequestDTO newBusinessObjectDTO(final CalculationRequest businessObject)
    {
        CalculationRequestDTO calculationRequestDTO = new CalculationRequestDTO();
        calculationRequestDTO.setPatient(patientMapper.newBusinessObjectDTO(businessObject.getPatient()));
        calculationRequestDTO.setDeltaTime(businessObject.getDeltaTime());
        calculationRequestDTO.setModel(businessObject.getModel().getValue());

        calculationRequestDTO.setPumpInfusion(pumpInfusionMapper.newBusinessObjectDTOList(businessObject.getInfusionRequestList()));

        return  calculationRequestDTO;
    }
}
