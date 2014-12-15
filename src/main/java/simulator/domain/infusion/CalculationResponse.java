package simulator.domain.infusion;

import lombok.Data;

import java.util.List;

/**
 * The simulation response containing the plasma, and effect site concentration
 * by second. Also the necessary infusions.
 *
 */
@Data
public class CalculationResponse
{
    ErrorCode errorCode = ErrorCode.NO_ERROR;
    List<Double> siteConcentrationsData;
    List<Double> plasmaConcentrationsData;
    List<PumpInfusion> infusionList;

    public static enum ErrorCode
    {
        NO_ERROR(0), UNREACHABLE_INFUSION(1);

        ErrorCode(int value)
        {
            this.value = value;
        }

        private int value;
        public int getValue()
        {
            return value;
        }
    }
}
