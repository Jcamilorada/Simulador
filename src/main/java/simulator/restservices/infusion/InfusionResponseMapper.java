package simulator.restservices.infusion;

import org.springframework.stereotype.Component;
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
    @Override
    public InfusionResponse newBusinessObject(InfusionResponseDTO businessObjectDTO)
    {
        return new InfusionResponse(businessObjectDTO.getTime(), businessObjectDTO.getInfusionValue());
    }

    @Override
    public InfusionResponseDTO newBusinessObjectDTO(InfusionResponse businessObject)
    {
        return new InfusionResponseDTO(businessObject.getTime(), businessObject.getInfusionValue());
    }
}
