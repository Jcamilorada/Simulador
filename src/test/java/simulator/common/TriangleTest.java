package simulator.common;

import junit.framework.TestCase;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import simulator.common.graphic.Point;
import simulator.common.graphic.Triangle;

@RunWith(Theories.class)
public class TriangleTest
{
    private Point point1 = new Point(10D, 20D, 30D, 1);
    private Point point2 = new Point(10D, 20D, 30D, 2);
    private Point point3 = new Point(10D, 20D, 30D, 3);
    
    @DataPoint
    public static Point nullPoint = null;

    @DataPoint
    public static Point validPoint = new Point(10D, 20D, 5D, 1);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Theory
    public void testConstructor(Point point1, Point point2, Point point3)
    {
        Assume.assumeTrue(point1 == null || point2 == null || point3 == null);
        expectedException.expect(NullPointerException.class);
        new Triangle(point1, point2, point3);
    }

    @Test
    public void testEqualsSameInstance()
    {
        Triangle triangle = new Triangle(point1, point2, point3);
        TestCase.assertTrue("Equals should return true", triangle.equals(triangle));
    }

    @Test
    public void testEqualsWithDifferentClass()
    {
        Triangle triangle = new Triangle(point1, point2, point3);
        TestCase.assertFalse("Equals should return true", triangle.equals(new String()));
    }

    @Test
    public void testEqualsWithDifferentInstance()
    {
        Triangle triangle = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point1, point2, point3);
        TestCase.assertTrue("Equals should return true", triangle.equals(triangle2));
    }

    @Test
    public void testHashCodeWithDifferentInstanceSameData()
    {
        Triangle triangle = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point1, point2, point3);
        TestCase.assertEquals("Equals should return true", triangle.hashCode(), triangle2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentInstanceDifferentData()
    {
        Triangle triangle = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point1, point2, point1);
        TestCase.assertNotSame("Equals should return true", triangle.hashCode(), triangle2.hashCode());
    }
}
