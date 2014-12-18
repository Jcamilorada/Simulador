package simulator.restservices.infusion;

import org.springframework.stereotype.Component;
import simulator.domain.infusion.PumpInfusion;
import simulator.dto.PumpInfusionDTO;
import simulator.restservices.common.AbstractBusinessObjectMapper;
import simulator.restservices.common.IBusinessObjectMapper;

@Component
class PumpInfusionMapper extends AbstractBusinessObjectMapper<PumpInfusion, PumpInfusionDTO>
{

    @Override
    public PumpInfusion newBusinessObject(PumpInfusionDTO businessObjectDTO)
    {
        return new PumpInfusion(businessObjectDTO.getTime(), businessObjectDTO.getInfusion());
    }

    @Override
    public PumpInfusionDTO newBusinessObjectDTO(PumpInfusion businessObject)
    {
        return new PumpInfusionDTO(businessObject.getTime(), businessObject.getInfusion());
    }
}
