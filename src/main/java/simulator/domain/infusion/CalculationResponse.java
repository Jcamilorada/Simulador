package simulator.domain.infusion;

import lombok.Data;
import simulator.common.exceptions.EnumCastException;

import java.util.List;
import simulator.domain.infusion.calculations.ESCComponentValues;
import simulator.domain.infusion.calculations.PlasmaComponentValues;

/**
 * The simulation response containing the plasma, and effect site concentration
 * by second. Also the necessary infusions.
 *
 */
@Data
public class CalculationResponse
{
    ErrorCode errorCode = ErrorCode.NO_ERROR;
    String ErrorMessage;

    List<ESCComponentValues> siteConcentrationsData;
    List<PlasmaComponentValues> plasmaConcentrationsData;
    List<InfusionResponse> infusionList;
    List<Double> pnrData;

    public static enum ErrorCode
    {
        NO_ERROR(0), UNREACHABLE_CONCENTRATION(1);

        ErrorCode(int value)
        {
            this.value = value;
        }

        private int value;
        public int getValue()
        {
            return value;
        }

        public static ErrorCode fromValue(int value)
        {
            switch (value)
            {
                case 0:
                    return  ErrorCode.NO_ERROR;
                case 1:
                    return  ErrorCode.UNREACHABLE_CONCENTRATION;
                default:
                    throw new EnumCastException(value);
            }
        }
    }
}
