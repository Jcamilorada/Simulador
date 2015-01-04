package simulator.restservices.infusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.util.DoubleUtil;
import simulator.configuration.PumpProperties;
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
    private final PumpProperties pumpProperties;

    @Autowired
    CalculationResponseMapper(final InfusionResponseMapper infusionResponseMapper, final PumpProperties pumpProperties)
    {
        this.infusionResponseMapper = infusionResponseMapper;
        this.pumpProperties = pumpProperties;
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


        calculationResponseDTO.setPlasmaConcentrationsData(DoubleUtil.roundDoubleList(
            businessObject.getPlasmaConcentrationsData(),
            pumpProperties.getDecimalPlaces()));
        calculationResponseDTO.setSiteConcentrationsData(DoubleUtil.roundDoubleList(
            businessObject.getSiteConcentrationsData(),
            pumpProperties.getDecimalPlaces()));

        return calculationResponseDTO;
    }


}
