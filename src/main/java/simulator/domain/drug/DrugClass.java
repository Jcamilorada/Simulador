package simulator.domain.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simulator.common.exceptions.EnumCastException;

@AllArgsConstructor
public enum DrugClass
{
    HYPNOTIC(1), RELAXING(2), OPIOID(3);

    @Getter
    @Setter
    private int value;

    public static DrugClass fromValue(final int value)
    {
        switch (value)
        {
            case 1:
                return HYPNOTIC;
            case 2:
                return RELAXING;
            case 3:
                return OPIOID;
            default:
                throw new EnumCastException(value);
        }
    }

    public static DrugClass fromDrugType(final DrugType drugType)
    {
        switch (drugType)
        {
            case REMIFENTANILO:
                return DrugClass.RELAXING;
            case PROPOFOL:
                return DrugClass.HYPNOTIC;
            default:
                return DrugClass.HYPNOTIC;
        }
    }
}
