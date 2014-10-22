package simulator.common;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import simulator.common.graphic.Point;

public class PointTest
{
    @Test
    public void testConstructor()
    {
        final double x = 5.0D;
        final double y = 6.0D;
        final double z = 7.0D;
        final int index = 2;

        Point point = new Point(x , y , z, index);
        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
        assertEquals(z, point.getZ());
        assertEquals(index, point.getIndex());
    }
}
