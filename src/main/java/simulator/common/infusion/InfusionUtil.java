package simulator.common.infusion;

// TODO: Update calculator.
public class InfusionUtil
{
    public static double litersHourToMicroGramHour(
        final double liter_Hour, final double weight)
    {
        return liter_Hour / weight;
    }

    public static double litersHourToMicroGramHour(
        final double liter_Hour, final double weight, double drugAmount, double disolutionVolume)
    {
        double concf = drugAmount/disolutionVolume;
        return concf;
    }
}
