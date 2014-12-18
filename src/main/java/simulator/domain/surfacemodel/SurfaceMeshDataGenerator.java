package simulator.domain.surfacemodel;

import org.springframework.stereotype.Component;
import simulator.common.graphic.Color;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;

@Component
class SurfaceMeshDataGenerator
{
    private static double EPSILON = 0.0828d;
    private static double GAMMA = 5.1550d;

    private static double VALUE = 1;
    private static double SATURATION = 1;

    PointsTable generateDataPoints(
        final double deltaX, final double deltaY, final double initX, final double initY, final double maxX, final double maxY)
    {
        PointsTable pointsTable = new PointsTable();
        int pointIndex = 0;

        for (double x = initX; x < maxX; x = x + deltaX)
        {
            for (double y = initY; y < maxY; y = y + deltaY)
            {
                Point point = createPoint(x, y, pointIndex);
                pointsTable.put(x, y, point);
                pointIndex++;
            }
        }
        return pointsTable;
    }

    Point createPoint(final double x, final double y, final int index)
    {
        double pnr = SurfaceModelCalculator.getPNR(x, y);
        Color color = getPointColor(pnr);
        Point point = new Point(x, y, pnr, index, color);

        return point;
    }

    Color getPointColor(final double z)
    {
        double h = z * 2 * Math.PI / 6;
        return new Color(h, SATURATION, VALUE);
    }
}
