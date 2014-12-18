package simulator.common.graphic;

import junit.framework.TestCase;
import org.junit.Test;

public class ColorTest
{
    private static final double H = 1d;
    private static final double S = 0.5d;
    private static final double B = 0.3d;

    @Test
    public void testContructor()
    {
        Color color = new Color(1d, 0.5d, 0.3d);
        TestCase.assertEquals("wrong H value", H, color.getH());
        TestCase.assertEquals("wrong S value", S, color.getS());
        TestCase.assertEquals("wrong B value", B, color.getB());
        TestCase.assertEquals("wrong integer value RGB representation", ColorUtils.HSBtoRGB(H, S, B), color.getValue());
    }
}
