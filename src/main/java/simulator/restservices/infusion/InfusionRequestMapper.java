package simulator.restservices.infusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.util.DoubleUtil;
import simulator.configuration.PumpProperties;
import simulator.domain.infusion.InfusionRequest;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code PumpInfusion} domain and {@code PumpInfusionDTO} DTO mapper.
 */
@Component
class InfusionRequestMapper extends AbstractBusinessObjectMapper<InfusionRequest, InfusionRequestDTO>
{
    @Override
    public InfusionRequest newBusinessObject(final InfusionRequestDTO businessObjectDTO)
    {
        return new InfusionRequest(
            businessObjectDTO.getStartTime(), businessObjectDTO.getEndTime(), businessObjectDTO.getInfusion());
    }

    @Override
    public InfusionRequestDTO newBusinessObjectDTO(final InfusionRequest businessObject)
    {
        return new InfusionRequestDTO(
            businessObject.getStartTime(),
            businessObject.getEndTime(),
            businessObject.getConcentration());
    }
}
