package simulator.common.util;

import com.google.common.base.Preconditions;

public class DoubleUtils
{
    private DoubleUtils()
    {
    }

    public static double roundDouble(final double number, final int decimalPlaces)
    {
        Preconditions.checkArgument(decimalPlaces > 0, "decimalPlaces should be greater that 0");


        double factor = Math.pow(10, decimalPlaces);
        double result =
            Math.round(number * factor) / factor;

        return result;
    }
}
