package simulator.services.graphic.surfacemodel;

import com.google.common.primitives.Doubles;
import org.springframework.stereotype.Component;
import simulator.common.graphic.Color;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Point;
import simulator.common.util.ColorUtils;

/**
 Remifentanil and Propofol surface model calculator. The surface model calculates the PN (No response probability)
 based on Remifentanil and Propofol concentrations.

 z(x, y) = (εxy)^ γ / 1 + (εxy)^ γ

 z(x, y) = (0.0828 * x * y)^ 5.1550 / 1 + (0.0828 * x * y)^ 5.1550

 x: Remifentanil. The Remifentanil concentration μg/ml.
 y: Propofol. The propofol concentration ng/ml

 z(x,y) = z: The no response probability.

 */
@Component
class SurfaceModelCalculator
{
    private static double EPSILON = 0.0828d;
    private static double GAMMA = 5.1550d;

    private static double VALUE = 1;
    private static double SATURATION = 1;

    PointsTable generateDataPoints(
        final double deltaX,
        final double deltaY,
        final double initX,
        final double initY,
        final double maxX,
        final double maxY)
    {
        PointsTable pointsTable = new PointsTable();
        int pointIndex = 0;

        for (double x = initX; x < maxX; x = x + deltaX)
        {
            for (double y = initY; y < maxY; y = y + deltaY)
            {
                Point point = createPoint(x, y, pointIndex);
                pointsTable.put(x, y, point);
                pointIndex ++;
            }
        }
        return pointsTable;
    }

    Point createPoint(final double x, final double y, final int index)
    {
        double pnr = caculatePNR(x, y);
        Color color = getPointColor(pnr);
        Point point = new Point(x, y, caculatePNR(x, y), index, color);

        return point;
    }

    /**
     *
     * @param x the Remifentanil concentration μg/ml.
     * @param y The propofol concentration ng/ml.
     * @return The no response probability.
     */
    double caculatePNR(final double x, final double y)
    {
        double operand = Math.pow((x * y * EPSILON), GAMMA);
        double z = operand / (1 + operand);
        return z;
    }

    Color getPointColor(final double z)
    {
        double h = z * 2 * Math.PI /6;
        return new Color(h, SATURATION, VALUE);
    }
}
