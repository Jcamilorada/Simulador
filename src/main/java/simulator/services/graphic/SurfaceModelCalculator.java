package simulator.services.graphic;

import simulator.common.graphic.Point;

import java.util.ArrayList;
import java.util.List;

/**
 Remifentanil and Propofol surface model calculator. The surface model calculates the PN (No response probability)
 based on Remifentanil and Propofol concentrations.

 z(x, y) = (εxy)^ γ / 1 + (εxy)^ γ

 x: Remifentanil. The Remifentanil concentration μg/ml.
 y: Propofol. The propofol concentration ng/ml

 z(x,y) = z: The no response probability.

 */
class SurfaceModelCalculator
{
    private static double epsilon = 0.0828D;
    private static double gamma = 5.1550D;

    public List<Point> generateDataPoints(
        final double deltaX, final double deltaY, final double maxX, final double maxY)
    {
        List<Point> points = new ArrayList<Point>();
        int pointIndex = 0;

        for (double x = 0; x < maxX; x = x + deltaX)
        {
            for (double y = 0; y < maxY; x = y + deltaY)
            {
                Point point = new Point(x, y, caculatePNR(x, y), pointIndex);
                points.add(point);
            }
        }

        return  points;
    }

    /**
     *
     * @param x the Remifentanil concentration μg/ml.
     * @param y The propofol concentration ng/ml.
     * @return The no response probability.
     */
    private double caculatePNR(final double x, final double y)
    {
        double operand = Math.pow((x * y * epsilon), gamma);
        double z = operand / 1 + operand;
        return z;
    }
}
