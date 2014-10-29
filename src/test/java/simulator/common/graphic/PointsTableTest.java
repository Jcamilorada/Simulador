package simulator.common.graphic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PointsTableTest
{
    private PointsTable testInstance = new PointsTable();
    private Color color;

    @Test
    public void testGetAndPut()
    {
        TestCase.assertNull("element should be null", testInstance.get(0,2));

        final Point point = new Point(0d,0d,0d,1, color);
        testInstance.put(0, 2, point);

        TestCase.assertEquals("wrong point", point, testInstance.get(0, 2));
    }

    @Test
    public void testGetPoints()
    {
        final Point point1 = new Point(0d,0d,0d,1, color);
        final Point point2 = new Point(0d,0d,0d,2, color);
        final Point point3 = new Point(0d,0d,0d,3, color);

        testInstance.put(0d, 1d, point2);
        testInstance.put(0d, 0d, point1);
        testInstance.put(2d, 3d, point3);

        List<Point> points =  testInstance.getPoints();
        TestCase.assertEquals("wrong point value", point1, points.get(0));
        TestCase.assertEquals("wrong point value", point2, points.get(1));
        TestCase.assertEquals("wrong point value", point3, points.get(2));
    }

    @Test
    public void testSize()
    {
        TestCase.assertEquals("size should be zero", 0, testInstance.size());
    }
}
