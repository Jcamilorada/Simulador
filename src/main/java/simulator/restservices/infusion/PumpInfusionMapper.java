package simulator.restservices.infusion;

import org.springframework.stereotype.Component;
import simulator.domain.infusion.PumpInfusion;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code PumpInfusion} domain and {@code PumpInfusionDTO} DTO mapper.
 */
@Component
class PumpInfusionMapper extends AbstractBusinessObjectMapper<PumpInfusion, PumpInfusionDTO>
{

    @Override
    public PumpInfusion newBusinessObject(final PumpInfusionDTO businessObjectDTO)
    {
        return new PumpInfusion(businessObjectDTO.getTime(), businessObjectDTO.getInfusion());
    }

    @Override
    public PumpInfusionDTO newBusinessObjectDTO(final PumpInfusion businessObject)
    {
        return new PumpInfusionDTO(businessObject.getTime(), businessObject.getInfusion());
    }
}
