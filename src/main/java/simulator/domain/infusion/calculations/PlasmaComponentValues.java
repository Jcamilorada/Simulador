package simulator.domain.infusion.calculations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by alevalv on 2/5/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlasmaComponentValues
{
    private double p1;
    private double p2;
    private double p3;

    public double getSum()
    {
        return p1 + p2 + p3;
    }
}
