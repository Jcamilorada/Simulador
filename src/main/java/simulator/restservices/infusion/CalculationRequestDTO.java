package simulator.restservices.infusion;

import java.util.List;
import lombok.Data;

/**
 * @author Juan Camilo Rada
 *
 * Calculation Request data transfer object. This class encapsulate the neccesary information to perform and pump
 * infusion simulation.
 */
@Data
public class CalculationRequestDTO
{
    private double drugConcentration;
    private int deltaTime;
    private int model;
    private ESCComponentValuesDTO componentValuesDTO;
    private PlasmaComponentValuesDTO plasmaComponentValuesDTO;
    private PatientDTO patient;
    private List<InfusionRequestDTO> pumpInfusion;
}
