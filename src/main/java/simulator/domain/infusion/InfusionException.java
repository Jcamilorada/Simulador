package simulator.domain.infusion;

import com.google.common.base.Preconditions;
import lombok.Getter;

/**
 * @author Alejandro Valdes
 */
public class InfusionException extends IllegalArgumentException
{
    private static final String ERROR_MESSAGE_TEMPLATE = "The concentration %f with time %d is not achievable";

    @Getter
    private final double concentration;
    @Getter
    private final int time;

    public InfusionException(final double concentration, final int time)
    {
        this.concentration = Preconditions.checkNotNull(concentration);
        this.time = Preconditions.checkNotNull(time);
    }

    @Override
    public String getMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, concentration, time);
    }
}
