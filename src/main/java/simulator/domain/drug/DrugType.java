package simulator.domain.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simulator.common.exceptions.EnumCastException;

@AllArgsConstructor
public enum DrugType
{
    OPIOID(1), HYPNOTIC(2);

    @Getter @Setter
    private int value;

    public static DrugType fromValue(final int value)
    {
        switch (value)
        {
            case 1:
                return OPIOID;
            case 2:
                return HYPNOTIC;
            default:
                throw new EnumCastException(value);
        }
    }
}
