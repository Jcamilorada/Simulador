package simulator.restservices.infusion;

import lombok.Data;

import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Calculation Request data transfer object. This class encapsulate the neccesary information to perform and pump
 * infusion simulation.
 */
@Data
public class CalculationRequestDTO
{
    private int deltaTime;
    private int model;
    private PatientDTO patient;
    private List<PumpInfusionDTO> pumpInfusion;
}
