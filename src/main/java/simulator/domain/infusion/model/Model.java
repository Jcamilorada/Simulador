package simulator.domain.infusion.model;

import simulator.common.exceptions.EnumCastException;

public enum Model
{
    Minto(0), Schider(1);

    private int value;

    private Model(final int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public static Model fromValue(final int value)
    {
        switch (value)
        {
            case 0:
                return Minto;
            case 1:
                return Schider;
            default:
                throw new EnumCastException(value);
        }
    }
}
