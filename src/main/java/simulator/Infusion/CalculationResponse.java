package simulator.Infusion;

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
    List<Double> siteConcentrationsData;
    List<Double> plasmaConcentrationsData;
    List<PumpInfunsions> infusionList;
}
