package simulator.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalculationRequestDTO
{
    private int deltaTime;

    /* Model identificaction number 0(Minto) - 1(Schider)  */
    private int model;

    private PatientDTO patient;

    private List<PumpInfusionDTO> pumpInfusion;
}
