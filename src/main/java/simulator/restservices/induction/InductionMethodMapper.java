package simulator.restservices.induction;

import org.springframework.stereotype.Component;
import simulator.domain.induction.InductionMethod;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * @author Juan Camilo Rada
 *
 * {@code InductionMethod} and  {@code InductionMethodDTO} mapper.
 */
@Component
public class InductionMethodMapper extends AbstractBusinessObjectMapper<InductionMethod, InductionMethodDTO>
{
    @Override
    public InductionMethod newBusinessObject(InductionMethodDTO businessObjectDTO)
    {
        InductionMethod inductionMethod = new InductionMethod();
        inductionMethod.setId(businessObjectDTO.getId());
        inductionMethod.setName(businessObjectDTO.getName());
        inductionMethod.setProp(businessObjectDTO.getProp());
        inductionMethod.setRemi(businessObjectDTO.getRemi());

        return inductionMethod;
    }

    @Override
    public InductionMethodDTO newBusinessObjectDTO(InductionMethod businessObject)
    {
        InductionMethodDTO inductionMethodDTO = new InductionMethodDTO();
        inductionMethodDTO.setId(businessObject.getId());
        inductionMethodDTO.setName(businessObject.getName());
        inductionMethodDTO.setProp(businessObject.getProp());
        inductionMethodDTO.setRemi(businessObject.getRemi());

        return inductionMethodDTO;
    }
}
