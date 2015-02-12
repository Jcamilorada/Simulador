package simulator.domain.infusion;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alejandro Valdes
 */
@Data
@AllArgsConstructor
public class InfusionResponse
{
    /** The time where the infusion has to be done. */
    private int time;

    /** The time where the infusion has to be done. */
    private int endTime;

    /** The amount of drug that it has to be used. */
    private double infusionValue;

    /** The amount of drug in ug/kg/h */
    private double alternativeInfusionValue;
}
