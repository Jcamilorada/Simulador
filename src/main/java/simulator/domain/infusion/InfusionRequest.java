package simulator.domain.infusion;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class InfusionRequest
{
    /** Start time for this infusion request. */
    private int startTime;

    /** End time for this infusion request. */
    private int endTime;

    /** The concentration needed in this time interval. */
    private double concentration;
}
