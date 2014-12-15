package simulator.domain.common;

public enum Gender
{
    Male(1), Female(2);

    private int value;

    private Gender(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public static Gender fromValue(int value)
    {
        return Gender.values()[value];
    }
}
