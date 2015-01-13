package simulator.domain.recomendation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simulator.common.exceptions.EnumCastException;

@AllArgsConstructor
public enum SentenceType
{
    SINGLE_OPTION(1), MULTIPLE_OPTION_SINGLE_SELECTION(2), MULTIPLE_OPTION_MULTIPLE_SELECTION(3);

    @Getter @Setter
    private int value;

    public static SentenceType fromValue(final int value)
    {
        switch (value)
        {
            case 1:
                return SINGLE_OPTION;
            case 2:
                return MULTIPLE_OPTION_SINGLE_SELECTION;
            case 3:
                return MULTIPLE_OPTION_MULTIPLE_SELECTION;
            default:
                throw new EnumCastException(value);
        }
    }
}
