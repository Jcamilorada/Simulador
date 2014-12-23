package simulator.common.util;

/**
 * @author Juan Camilo Rada
 *
 * Double util to perform color operations.
 */
public class DoubleUtil
{
    private DoubleUtil()
    {
    }

    /**
     * Round the double to the specified number of decimal position.
     * The decimal places should be greater that 0.
     *
     * @param number the double number to round.
     * @param decimalPlaces the number of decimal positions.
     *
     * @return a rounded double.
     */
    public static double roundDouble(final double number, final int decimalPlaces)
    {
        assert decimalPlaces > 0;

        double factor = Math.pow(10, decimalPlaces);
        double result = Math.round(number * factor) / factor;

        return result;
    }
}
