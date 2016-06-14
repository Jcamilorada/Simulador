package simulator.domain.surfacemodel;

import org.springframework.stereotype.Component;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
class TriangleMeshGenerator
{
    List<Triangle> getMesh(
        final PointsTable pointsTable,
        final double deltaX,
        final double deltaY,
        final double initX,
        final double initY,
        final double maxX,
        final double maxY)
    {
        List<Triangle> triangles = new ArrayList<>(pointsTable.size());
        for (double x = initX; x < maxX - 1; x += deltaX)
        {
            for (double y = initY; y < maxY - 1; y += deltaY)
            {
                triangles.addAll(generateTriangles(x, y, deltaX, deltaY, pointsTable));
            }
        }

        return triangles;
    }

    private List<Triangle> generateTriangles(
        final double x,
        final double y,
        final double deltaX,
        final double deltaY,
        final PointsTable dataPoints)
    {
        Point point = dataPoints.get(x, y);
        Point upNeighbor = dataPoints.get(x, y + deltaY);
        Point rightNeighbor = dataPoints.get(x + deltaX, y);
        Point rightUpNeighbor = dataPoints.get(x + deltaX, y + deltaY);

        Triangle triangle1 = new Triangle(point, rightNeighbor, upNeighbor);
        Triangle triangle2 = new Triangle(rightUpNeighbor, upNeighbor, rightNeighbor);

        return Arrays.asList(triangle1, triangle2);
    }
}
