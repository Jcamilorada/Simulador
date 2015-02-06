package simulator.restservices.infusion;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    private final EffectSiteValuesMapper effectSiteValuesMapper;
    private final PlasmaValuesMapper plasmaValuesMapper;

    @Autowired
    CalculationResponseMapper(
        final InfusionResponseMapper infusionResponseMapper,
        final EffectSiteValuesMapper effectSiteValuesMapper,
        final PlasmaValuesMapper plasmaValuesMapper,
        final PumpProperties pumpProperties)
    {
        Preconditions.checkNotNull(pumpProperties);
        this.infusionResponseMapper = Preconditions.checkNotNull(infusionResponseMapper);
        this.effectSiteValuesMapper = Preconditions.checkNotNull(effectSiteValuesMapper);
        this.plasmaValuesMapper = Preconditions.checkNotNull(plasmaValuesMapper);
        effectSiteValuesMapper.setDecimalPlaces(pumpProperties.getDecimalPlaces());
        plasmaValuesMapper.setDecimalPlaces(pumpProperties.getDecimalPlaces());
    }

    @Override
    public CalculationResponse newBusinessObject(CalculationResponseDTO businessObjectDTO)
    {
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setErrorCode(CalculationResponse.ErrorCode.fromValue(businessObjectDTO.getErrorCode()));
        calculationResponse.setInfusionList(infusionResponseMapper.newBusinessObjectList(businessObjectDTO.getInfusionList()));
        calculationResponse.setPlasmaConcentrationsData(
            plasmaValuesMapper.newBusinessObjectList(businessObjectDTO.getPlasmaConcentrationsData()));
        calculationResponse.setSiteConcentrationsData(
            effectSiteValuesMapper.newBusinessObjectList(businessObjectDTO.getSiteConcentrationsData()));

        return calculationResponse;
    }

    @Override
    public CalculationResponseDTO newBusinessObjectDTO(CalculationResponse businessObject)
    {
        CalculationResponseDTO calculationResponseDTO = new CalculationResponseDTO();
        calculationResponseDTO.setErrorCode(businessObject.getErrorCode().getValue());
        calculationResponseDTO.setInfusionList(infusionResponseMapper.newBusinessObjectDTOList(businessObject.getInfusionList()));


        calculationResponseDTO.setPlasmaConcentrationsData(
            plasmaValuesMapper.newBusinessObjectDTOList(businessObject.getPlasmaConcentrationsData()));
        calculationResponseDTO.setSiteConcentrationsData(
            effectSiteValuesMapper.newBusinessObjectDTOList(businessObject.getSiteConcentrationsData()));

        return calculationResponseDTO;
    }
}
