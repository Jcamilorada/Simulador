package simulator.domain.infusion;

import lombok.Data;
import simulator.domain.common.Patient;

import java.util.List;
import simulator.domain.infusion.model.IModel;
import simulator.domain.infusion.model.Model;

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
    private Model model;
}
