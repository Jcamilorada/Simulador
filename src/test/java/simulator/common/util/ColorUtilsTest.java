package simulator.common.util;

import junit.framework.TestCase;
import org.junit.Test;

public class ColorUtilsTest
{
    @Test
    public void testHSBtoRGB()
    {
        int color = ColorUtils.HSBtoRGB(0f, 0.5f, 0.5f);
        TestCase.assertEquals("wrong color int value", 8405056, color);
    }
}
