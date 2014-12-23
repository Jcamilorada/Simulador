package simulator.restservices.infusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.domain.infusion.CalculationResponse;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code CalculationResponse} and  {@code CalculationResponseDTO} mapper.
 */
@Component
class CalculationResponseMapper extends AbstractBusinessObjectMapper<CalculationResponse, CalculationResponseDTO>
{
    private final InfusionResponseMapper infusionResponseMapper;

    @Autowired
    CalculationResponseMapper(final InfusionResponseMapper infusionResponseMapper)
    {
        this.infusionResponseMapper = infusionResponseMapper;
    }

    @Override
    public CalculationResponse newBusinessObject(CalculationResponseDTO businessObjectDTO)
    {
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setErrorCode(CalculationResponse.ErrorCode.fromValue(businessObjectDTO.getErrorCode()));
        calculationResponse.setInfusionList(infusionResponseMapper.newBusinessObjectList(businessObjectDTO.getInfusionList()));
        calculationResponse.setPlasmaConcentrationsData(businessObjectDTO.getPlasmaConcentrationsData());
        calculationResponse.setSiteConcentrationsData(businessObjectDTO.getSiteConcentrationsData());

        return calculationResponse;
    }

    @Override
    public CalculationResponseDTO newBusinessObjectDTO(CalculationResponse businessObject)
    {
        CalculationResponseDTO calculationResponseDTO = new CalculationResponseDTO();
        calculationResponseDTO.setErrorCode(businessObject.getErrorCode().getValue());
        calculationResponseDTO.setInfusionList(infusionResponseMapper.newBusinessObjectDTOList(businessObject.getInfusionList()));
        calculationResponseDTO.setPlasmaConcentrationsData(businessObject.getPlasmaConcentrationsData());
        calculationResponseDTO.setSiteConcentrationsData(businessObject.getSiteConcentrationsData());

        return calculationResponseDTO;
    }
}
