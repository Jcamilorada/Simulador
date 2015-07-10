package simulator.domain.infusion;

import java.util.ArrayList;
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
    private ErrorCode errorCode = ErrorCode.NO_ERROR;
    private String ErrorMessage;

    private List<ESCComponentValues> siteConcentrationsData = new ArrayList<>();
    private List<PlasmaComponentValues> plasmaConcentrationsData = new ArrayList<>();
    private List<InfusionResponse> infusionList = new ArrayList<>();
    private List<Double> pnrData = new ArrayList<>();

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
