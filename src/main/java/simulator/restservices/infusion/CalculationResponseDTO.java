package simulator.restservices.infusion;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

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
    List<InfusionResponseDTO> infusionList;
    List<ESCComponentValuesDTO> siteConcentrationsData;
    List<PlasmaComponentValuesDTO> plasmaConcentrationsData;
}
