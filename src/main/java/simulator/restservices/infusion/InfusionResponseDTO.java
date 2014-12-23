package simulator.restservices.infusion;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO class for an infusion response.
 *
 * @author Alejandro Valdes
 */
@Data
@AllArgsConstructor
public class InfusionResponseDTO
{
    /** The time where the infusion has to be done. */
    private int time;

    /** The amount of drug that it has to be used. */
    private double infusionValue;
}
