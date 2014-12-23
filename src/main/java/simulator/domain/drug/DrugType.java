package simulator.domain.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simulator.common.exceptions.EnumCastException;

@AllArgsConstructor
public enum DrugType
{
    REMIFENTANILO(1), PROPOFOL(2);

    @Getter @Setter
    private int value;

    public static DrugType fromValue(final int value)
    {
        switch (value)
        {
            case 1:
                return REMIFENTANILO;
            case 2:
                return PROPOFOL;
            default:
                throw new EnumCastException(value);
        }
    }
}
