package simulator.services.graphic.surfacemodel;

import junit.framework.TestCase;
import org.junit.Test;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.services.graphic.surfacemodel.SurfaceModelCalculator;

public class SurfaceModelCalculatorTest
{
    private final SurfaceModelCalculator testInstance = new SurfaceModelCalculator();

    @Test
    public void testGenerateDataPoints()
    {
        PointsTable table = testInstance.generateDataPoints(1, 1, 2, 2);
        verifyPointsTable(table);
    }

    private void verifyPointsTable(PointsTable table)
    {
        TestCase.assertEquals("The table should contain 4 elements", 4, table.size());

        Point point1 = table.get(0, 0);
        Point point2 = table.get(0, 1);
        Point point3 = table.get(1, 0);
        Point point4 = table.get(1, 1);

        Point expectedPoint1 = new Point(0D, 0D, testInstance.caculatePNR(0, 0), 1);
        Point expectedPoint2 = new Point(0D, 1D, testInstance.caculatePNR(0, 1), 2);
        Point expectedPoint3 = new Point(1D, 0D, testInstance.caculatePNR(1, 0), 3);
        Point expectedPoint4 = new Point(1D, 1D, testInstance.caculatePNR(1, 1), 4);


        verifyPoint(expectedPoint1,  point1);
        verifyPoint(expectedPoint2,  point2);
        verifyPoint(expectedPoint3,  point3);
        verifyPoint(expectedPoint4,  point4);
    }

    private void verifyPoint(final Point expected, final Point actual)
    {
        TestCase.assertEquals("wrong x value", expected.getX(), expected.getX());
        TestCase.assertEquals("wrong y value", expected.getY(), expected.getY());
        TestCase.assertEquals("wrong z value", expected.getZ(), expected.getZ());
    }
}
