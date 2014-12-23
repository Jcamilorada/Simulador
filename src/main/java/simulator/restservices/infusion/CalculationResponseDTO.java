package simulator.restservices.infusion;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Calculation Response data transfer object. This class encapsulate the response information after perform a pump
 * infusion simulation.
 */
@Data
public class CalculationResponseDTO implements Serializable
{
    int errorCode = 0;
    List<Double> siteConcentrationsData;
    List<Double> plasmaConcentrationsData;
    List<InfusionResponseDTO> infusionList;
}
