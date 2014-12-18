package simulator.domain.infusion.model;

import com.google.common.base.Preconditions;
import simulator.domain.infusion.Patient;

/**
 * @author Alejandro Valdes
 */
public class ModelFactory
{
    private ModelFactory() {}

    public static IModel getModel(final Model model, final Patient patient)
    {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(patient);
        IModel actModel = null;
        switch (model)
        {
            case Minto:
                actModel = new MintoModel(patient);
                break;
            case Schider:
                actModel = new SchiderModel(patient);
                break;
            default:
                throw new IllegalArgumentException(String.format("The given model can't be mapped"));
        }
        return actModel;
    }
}
