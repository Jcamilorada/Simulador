package simulator.common.exceptions;

public class EnumCastException extends RuntimeException
{
    private static String MESSAGE_FORMAT ="Cant not find a value for %d";

    public EnumCastException(final int invalidValue)
    {
        super(String.format(EnumCastException.MESSAGE_FORMAT, invalidValue));
    }
}
