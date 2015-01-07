package simulator.domain.infusion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import simulator.domain.infusion.model.Model;

@Data
/**
 * The calculation request information containing all the necessary information
 * to perform the compartment drug simulation.
 */
public class CalculationRequest
{
    @Setter(AccessLevel.NONE)
    private int maximumTime;

    private int deltaTime;

    private double drugConcentration;

    private Patient patient;

    private Model model;

    @Getter(AccessLevel.NONE)
    private final Set<InfusionRequest> noPumpTimes = new HashSet<>();

    private final List<InfusionRequest> infusionRequestList = new ArrayList<>();

    public void setInfusionRequestList(final List<InfusionRequest> infusionRequestList)
    {
        this.infusionRequestList.clear();
        noPumpTimes.clear();
        for (int iterator=0; iterator < infusionRequestList.size(); iterator++)
        {
            InfusionRequest actualRequest = infusionRequestList.get(iterator);
            this.infusionRequestList.add(actualRequest);
            if (iterator + 1 < infusionRequestList.size())
            {
                InfusionRequest nextRequest = infusionRequestList.get(iterator + 1);
                if (actualRequest.getEndTime() < nextRequest.getStartTime())
                {
                    InfusionRequest keepInfusionRequest =
                        new InfusionRequest(
                            actualRequest.getEndTime(), nextRequest.getStartTime(), actualRequest.getConcentration());
                    this.infusionRequestList.add(keepInfusionRequest);
                    noPumpTimes.add(keepInfusionRequest);
                }
            }
            maximumTime = infusionRequestList.get(infusionRequestList.size() - 1).getEndTime();
        }
    }

    public boolean isInfusionForPumping(final InfusionRequest request)
    {
        return !noPumpTimes.contains(request);
    }
}
