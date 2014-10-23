package simulator.services.graphic;

import org.springframework.stereotype.Component;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Point;

/**
 Remifentanil and Propofol surface model calculator. The surface model calculates the PN (No response probability)
 based on Remifentanil and Propofol concentrations.

 z(x, y) = (εxy)^ γ / 1 + (εxy)^ γ

 x: Remifentanil. The Remifentanil concentration μg/ml.
 y: Propofol. The propofol concentration ng/ml

 z(x,y) = z: The no response probability.

 */
@Component
class SurfaceModelCalculator
{
    private static double EPSILON = 0.0828D;
    private static double GAMMA = 5.1550D;

    public PointsTable generateDataPoints(
        final double deltaX, final double deltaY, final double maxX, final double maxY)
    {
        PointsTable pointsTable = new PointsTable();
        int pointIndex = 0;

        for (double x = 0; x < maxX; x = x + deltaX)
        {
            for (double y = 0; y < maxY; y = y + deltaY)
            {
                Point point = new Point(x, y, caculatePNR(x, y), pointIndex);
                pointsTable.put(x, y, point);
                pointIndex ++;
            }
        }
        return pointsTable;
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
        double z = operand / 1 + operand;
        return z;
    }
}
