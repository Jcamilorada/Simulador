package simulator.infusion;

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

    public static enum ErrorCode {NO_ERROR, UNREACHABLE_INFUSION}
}
