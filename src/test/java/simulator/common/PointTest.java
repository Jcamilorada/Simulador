package simulator.common;

import static junit.framework.TestCase.assertEquals;

import junit.framework.TestCase;
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

    @Test
    public void testEqualsSameInstance()
    {
        Point point = new Point(0D, 0D, 0D, 1);
        TestCase.assertTrue("Equals should return true", point.equals(point));
    }

    @Test
    public void testEqualsWithDifferentClass()
    {
        Point point = new Point(0D, 0D, 0D, 1);
        TestCase.assertFalse("Equals should return true", point.equals(new String()));
    }

    @Test
    public void testEqualsWithDifferentInstanceSameData()
    {
        Point point = new Point(0D, 0D, 0D, 1);
        Point point2 = new Point(0D, 0D, 0D, 1);
        TestCase.assertTrue("Equals should return true", point.equals(point2));
    }

    @Test
    public void testHashCodeWithDifferentInstanceSameData()
    {
        Point point = new Point(0D, 0D, 0D, 1);
        Point point2 = new Point(0D, 0D, 0D, 1);
        TestCase.assertEquals("Equals should return true", point.hashCode(), point2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentInstanceDiferentData()
    {
        Point point = new Point(1D, 2D, 3D, 1);
        Point point2 = new Point(5D, 6D, 2D, 1);
        TestCase.assertNotSame("Equals should return true", point.hashCode(), point2.hashCode());
    }
}
