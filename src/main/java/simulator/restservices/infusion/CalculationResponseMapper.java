package simulator.restservices.infusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.CalculationResponse;
import simulator.dto.CalculationResponseDTO;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;

@Component
class CalculationResponseMapper extends AbstractBusinessObjectMapper<CalculationResponse, CalculationResponseDTO>
{
    private PumpInfusionMapper pumpInfusionMapper;

    @Autowired
    CalculationResponseMapper(final PumpInfusionMapper pumpInfusionMapper)
    {
        this.pumpInfusionMapper = pumpInfusionMapper;
    }

    @Override
    public CalculationResponse newBusinessObject(CalculationResponseDTO businessObjectDTO)
    {
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setErrorCode(CalculationResponse.ErrorCode.fromValue(businessObjectDTO.getErrorCode()));
        calculationResponse.setInfusionList(pumpInfusionMapper.newBusinessObjectList(businessObjectDTO.getInfusionList()));
        calculationResponse.setPlasmaConcentrationsData(businessObjectDTO.getPlasmaConcentrationsData());
        calculationResponse.setSiteConcentrationsData(businessObjectDTO.getSiteConcentrationsData());

        return calculationResponse;
    }

    @Override
    public CalculationResponseDTO newBusinessObjectDTO(CalculationResponse businessObject)
    {
        CalculationResponseDTO calculationResponseDTO = new CalculationResponseDTO();
        calculationResponseDTO.setErrorCode(businessObject.getErrorCode().getValue());
        calculationResponseDTO.setInfusionList(pumpInfusionMapper.newBusinessObjectDTOList(businessObject.getInfusionList()));
        calculationResponseDTO.setPlasmaConcentrationsData(businessObject.getPlasmaConcentrationsData());
        calculationResponseDTO.setSiteConcentrationsData(businessObject.getSiteConcentrationsData());

        return calculationResponseDTO;
    }
}
