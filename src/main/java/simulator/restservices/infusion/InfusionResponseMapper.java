package simulator.restservices.infusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.util.DoubleUtil;
import simulator.configuration.PumpProperties;
import simulator.domain.infusion.InfusionResponse;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * Mapper class for infusion response between domain and DTO layer.
 *
 * @author Alejandro Valdes
 */
@Component
public class InfusionResponseMapper extends AbstractBusinessObjectMapper<InfusionResponse, InfusionResponseDTO>
{
    private final PumpProperties pumpProperties;

    @Autowired
    public InfusionResponseMapper(final PumpProperties pumpProperties)
    {
        this.pumpProperties = pumpProperties;
    }

    @Override
    public InfusionResponse newBusinessObject(final InfusionResponseDTO businessObjectDTO)
    {
        return new InfusionResponse(
            businessObjectDTO.getTime(),
            businessObjectDTO.getInfusionValue(),
            businessObjectDTO.getAlternativeInfusionValue());
    }

    @Override
    public InfusionResponseDTO newBusinessObjectDTO(final InfusionResponse businessObject)
    {
        return new InfusionResponseDTO(
            businessObject.getTime(),
            DoubleUtil.roundDouble(businessObject.getInfusionValue(), pumpProperties.getDecimalPlaces()),
            businessObject.getAlternativeInfusionValue());
    }
}
