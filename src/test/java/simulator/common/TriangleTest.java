package simulator.common;

import org.junit.Assume;
import org.junit.Rule;
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
    @DataPoint
    public static Point nullPoint = null;

    @DataPoint
    public static Point validPoint = new Point(10D, 20D, 5D, 1);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Theory
    public void testContructor(Point point1, Point point2, Point point3)
    {
        Assume.assumeTrue(point1 == null || point2 == null || point3 == null);
        expectedException.expect(NullPointerException.class);
        new Triangle(point1, point2, point3);
    }
}
