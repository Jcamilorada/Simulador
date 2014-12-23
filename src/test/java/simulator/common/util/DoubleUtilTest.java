package simulator.common.util;

import junit.framework.TestCase;
import org.junit.Test;

public class DoubleUtilTest
{
    @Test
    public void testRoundDouble()
    {
        final double number = 10.41525;
        double result = DoubleUtil.roundDouble(number, 3);
        TestCase.assertEquals("wrong number", 10.415D, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoundDoubleWithNegativeValue()
    {
        DoubleUtil.roundDouble(5.2D, -5);
    }
}
