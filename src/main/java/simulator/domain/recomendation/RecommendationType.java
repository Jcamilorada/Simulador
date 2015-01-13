package simulator.domain.recomendation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simulator.common.exceptions.EnumCastException;

@AllArgsConstructor
public enum RecommendationType
{
    BEFORE_ANESTHESIA(1),BEFORE_SURGERY(2), BEFORE_OUT(3);

    @Getter
    @Setter
    private int value;

    public static RecommendationType fromValue(final int value)
    {
        switch (value)
        {
            case 1:
                return BEFORE_ANESTHESIA;
            case 2:
                return BEFORE_SURGERY;
            case 3:
                return BEFORE_OUT;
            default:
                throw new EnumCastException(value);
        }
    }
}
