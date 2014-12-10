package simulator.infusion;

import lombok.Data;
import simulator.domain.Patient;

import java.util.List;

@Data
/**
 * The calculation request information containing all the necesary information
 * to perform the compartment drug simulation.
 */
public class CalculationRequest
{
    List<PumpInfusion> infusionRequestList;
    private int deltaTime;
    private Patient patient;
    private IModel model;
}
