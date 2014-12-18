package simulator.restservices.infusion;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.PumpInfusion;
import simulator.domain.infusion.model.Model;
import simulator.dto.CalculationRequestDTO;
import simulator.dto.PumpInfusionDTO;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;

import java.util.ArrayList;
import java.util.List;

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
    public CalculationRequest newBusinessObject(CalculationRequestDTO businessObjectDTO)
    {
        CalculationRequest calculationRequest = new CalculationRequest();
        calculationRequest.setPatient(patientMapper.newBusinessObject(businessObjectDTO.getPatient()));
        calculationRequest.setDeltaTime(businessObjectDTO.getDeltaTime());
        calculationRequest.setInfusionRequestList(getInfusionRequestList(businessObjectDTO.getPumpInfusion()));
        calculationRequest.setModel(Model.fromValue(businessObjectDTO.getModel()));

        return  calculationRequest;
    }

    @Override
    public CalculationRequestDTO newBusinessObjectDTO(CalculationRequest businessObject)
    {
        return null;
    }

    private List<PumpInfusion> getInfusionRequestList(final List<PumpInfusionDTO> infusionDTOList)
    {
        List<PumpInfusion> infusions = new ArrayList<>(infusionDTOList.size());
        for (PumpInfusionDTO infusionDTO: infusionDTOList)
        {
            infusions.add(pumpInfusionMapper.newBusinessObject(infusionDTO));
        }

        return infusions;
    }
}
