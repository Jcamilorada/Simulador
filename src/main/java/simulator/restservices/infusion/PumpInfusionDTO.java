package simulator.restservices.infusion;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PumpInfusionDTO
{
    /* Elapsed time in second from simulation start. */
    private int time;

    /* Necessary infusion */
    private double infusion;
}
