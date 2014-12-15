package simulator.domain.infusion.model;

public enum Model
{
    Minto(0), Schider(1);

    private int value;

    private Model(final int value)
    {
        this.value = value;
    }

    int getValue()
    {
        return value;
    }

    public static Model fromValue(final int value)
    {
        return Model.values()[value];
    }
}
