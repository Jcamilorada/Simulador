package simulator.common.infusion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class infusionUtilTest
{
    @Test
    public void testConvert()
    {
        final int weight = 55;
        final double concentration = 10;
        final double infusion = 99;

        double result = InfusionUtil.convertUnits(infusion, weight, concentration);

        assertEquals("wrong units conversion", 18.0, result);
    }

    @Test
    public void testCalculateInfusion()
    {
        final int drugAmount = 45;
        final int solution = 500;

        double result = InfusionUtil.calculateInfusionConcentration(drugAmount, solution);
        assertEquals("wrong drug concentration value", 90.0, result);
    }

    @Test
    public void testConvertInfusion()
    {
        final double base10Value = 62;
        final double concentration = 90.0;

        double result = InfusionUtil.convertInfusion(base10Value, concentration);
        assertEquals("wrong infusion value", 7.0, result, 0.5);
    }

}
