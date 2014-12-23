package simulator.restservices.infusion;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InfusionRequestDTO
{
    /** Start time for this infusion request. */
    private int startTime;

    /** End time for this infusion request. */
    private int endTime;

    /** The infusion needed in this time interval. */
    private double infusion;
}
