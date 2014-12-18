package simulator.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CalculationResponseDTO implements Serializable
{
    int errorCode = 0;
    List<Double> siteConcentrationsData;
    List<Double> plasmaConcentrationsData;
    List<PumpInfusionDTO> infusionList;
}
