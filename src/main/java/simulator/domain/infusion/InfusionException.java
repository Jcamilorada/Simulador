package simulator.domain.infusion;

import com.google.common.base.Preconditions;
import lombok.Getter;

/**
 * @author Alejandro Valdes
 */
public class InfusionException extends IllegalArgumentException
{
    private static final String ERROR_MESSAGE_TEMPLATE = "The given infusion with time %d and infusion %f is not achievable";
    @Getter
    private final PumpInfusion request;

    public InfusionException(PumpInfusion request)
    {
        this.request = Preconditions.checkNotNull(request);
    }

    @Override
    public String getMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, request.getTime(), request.getInfusion());
    }
}
