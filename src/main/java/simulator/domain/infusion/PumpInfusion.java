package simulator.domain.infusion;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class PumpInfusion
{
    /* Elapsed time in second from simulation start. */
    private int time;

    /* Necessary infusion */
    private double infusion;
}
