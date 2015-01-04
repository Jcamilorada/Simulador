package simulator.common.infusion;

public class InfusionUtil
{
    /**
     * Convert from the infusion value in ml/h to ug/kg/h
     *
     * @param infusion the infusion value in ml/h.
     * @param weight the patient weight in kilograms.
     * @param drugConcentration the drug concentration in mg/ml
     *
     * @return the infusion equivalent in ug/kg/h
     */
    public static double convertUnits(
        final double infusion, final int weight, final double drugConcentration)
    {
        return infusion * drugConcentration/weight;
    }

    /**
     * Calculate the drug concentration based on drug mg and solution ml.
     *
     * @param drug the drug amount in mg.
     * @param solution the solution amount in ml.
     *
     * @return the drug concentration in mcg/ml
     */
    public static double calculateInfusionConcentration(
        final int drug, final int solution)
    {
        return (drug * 1000)/ solution;
    }

    /**
     * Convert the infution from base 10 concentration value to the specific concentration value on mcg/ml.
     *
     * @param base10Value the based on 10 mg/ml value;
     * @param concentration the concentration in mcg/ml.
     *
     * @return the infusion based on new concentration value.
     */
    public static double convertInfusion(double base10Value, double concentration)
    {
        return 10 * base10Value / concentration;
    }
}
