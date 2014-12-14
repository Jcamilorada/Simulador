package simulator.surfacemodel;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

public class SurfaceModelCalculatorTest
{
    @Test
    public void testCalculatePNR()
    {
        double calculatedPNR = SurfaceModelCalculator.caculatePNR(2.5d, 3.4d);
        double pnr = SurfaceModelCalculator.getPNR(2.5d, 3.4d);
        TestCase.assertEquals("Wrong pnr", calculatedPNR, pnr);
    }

    @Test
    public void testPossibleValues()
    {
        Set<Double> values = SurfaceModelCalculator.getPossiblesPNR();
        TestCase.assertEquals("Should be a pnr from 0.0 to 1", 101, values.size());
    }
}
