package simulator.restservices.infusion;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.stereotype.Component;
import simulator.common.util.DoubleUtil;
import simulator.domain.infusion.calculations.PlasmaComponentValues;
import simulator.restservices.common.AbstractBusinessObjectMapper;

/**
 * Created by alevalv on 2/6/15.
 */
@Component
public class PlasmaValuesMapper extends AbstractBusinessObjectMapper<PlasmaComponentValues, PlasmaComponentValuesDTO>
{
    @Setter(AccessLevel.PACKAGE)
    private int decimalPlaces = 2;

    @Override
    public PlasmaComponentValues newBusinessObject(PlasmaComponentValuesDTO businessObjectDTO)
    {
        return new PlasmaComponentValues(
        businessObjectDTO.getP1(), businessObjectDTO.getP2(), businessObjectDTO.getP3());
    }

    @Override
    public PlasmaComponentValuesDTO newBusinessObjectDTO(PlasmaComponentValues businessObject)
    {
        PlasmaComponentValuesDTO plasmaComponentValuesDTO = new PlasmaComponentValuesDTO();
        plasmaComponentValuesDTO.setP1(DoubleUtil.roundDouble(businessObject.getP1(), decimalPlaces));
        plasmaComponentValuesDTO.setP2(DoubleUtil.roundDouble(businessObject.getP2(), decimalPlaces));
        plasmaComponentValuesDTO.setP3(DoubleUtil.roundDouble(businessObject.getP3(), decimalPlaces));
        return plasmaComponentValuesDTO;
    }
}
