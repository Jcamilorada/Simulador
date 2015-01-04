package simulator.restservices.surfacemodel;

import lombok.Data;

import java.util.List;

@Data
public class PNRCalculationRequestDTO
{
    private List<Double> xvalues;
    private List<Double> yvalues;
}
