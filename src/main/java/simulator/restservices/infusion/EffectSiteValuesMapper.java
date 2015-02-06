package simulator.restservices.infusion;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.stereotype.Component;
import simulator.common.util.DoubleUtil;
import simulator.domain.infusion.calculations.ESCComponentValues;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * Created by alevalv on 2/6/15.
 */
@Component
class EffectSiteValuesMapper extends AbstractBusinessObjectMapper<ESCComponentValues, ESCComponentValuesDTO>
{
    @Setter(AccessLevel.PACKAGE)
    private int decimalPlaces = 2;

    @Override
    public ESCComponentValues newBusinessObject(ESCComponentValuesDTO businessObjectDTO) {
        return new ESCComponentValues(
            businessObjectDTO.getC1(),
            businessObjectDTO.getC2(),
            businessObjectDTO.getC3(),
            businessObjectDTO.getC4());
    }

    @Override
    public ESCComponentValuesDTO newBusinessObjectDTO(ESCComponentValues businessObject) {
        ESCComponentValuesDTO componentValuesDTO = new ESCComponentValuesDTO();
        componentValuesDTO.setC1(DoubleUtil.roundDouble(businessObject.getC1(), decimalPlaces));
        componentValuesDTO.setC2(DoubleUtil.roundDouble(businessObject.getC2(), decimalPlaces));
        componentValuesDTO.setC3(DoubleUtil.roundDouble(businessObject.getC3(), decimalPlaces));
        componentValuesDTO.setC4(DoubleUtil.roundDouble(businessObject.getC4(), decimalPlaces));
        return componentValuesDTO;
    }
}
