package simulator.Infusion;

import lombok.Data;
import simulator.domain.Patient;

@Data
/**
 * The calculation request information containing all the necesary information
 * to perform the compartment drug simulation.
 */
public class CalculationRequest
{
    private double concentration;
    private int time;
    private int deltaTime;
    private Patient patient;
    private IModel model;
}
