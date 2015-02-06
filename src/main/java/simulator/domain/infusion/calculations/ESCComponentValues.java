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
public class ESCComponentValues
{
    private double c1;
    private double c2;
    private double c3;
    private double c4;

    public double getSum()
    {
        return c1 + c2 + c3 + c4;
    }
}
