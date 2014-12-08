package simulator.Infusion;

import lombok.Data;

@Data
public class PumpInfunsions
{
    /* Elapsed time in second from simulation start. */
    private int time;

    /* Necessary infusion */
    private double infusion;
}
