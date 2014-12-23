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

    /** The amount of drug that it has to be used. */
    private double infusionValue;
}
