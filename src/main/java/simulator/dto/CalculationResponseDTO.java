package simulator.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalculationResponseDTO
{
    int errorCode = 0;
    List<Double> siteConcentrationsData;
    List<Double> plasmaConcentrationsData;
    List<PumpInfusionDTO> infusionList;
}
