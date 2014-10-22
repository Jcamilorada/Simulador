package simulator.services.graphic;

import com.google.common.base.Preconditions;
import simulator.common.graphic.Point;
import simulator.common.graphic.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TriangleMeshGenerator
{
    List<Triangle> getMesh(final Point[][] pointMatrix)
    {
        Preconditions.checkNotNull(pointMatrix, "point Matrix cannot be null");

        List<Triangle> triangles = new ArrayList<Triangle>(pointMatrix.length);

        int matrixLength = pointMatrix.length -1;
        for(int x =0; x < matrixLength; x++)
        {
            for (int y=0; y < matrixLength; y++)
            {
                triangles.addAll(generateTriangles(x, y, pointMatrix));
            }
        }

        return  triangles;
    }

    private List<Triangle> generateTriangles(final int x, final int y, final Point[][] pointMatrix)
    {
        Point point = pointMatrix[x][y];
        Point upNeighbord = pointMatrix[x][y+1];
        Point rightNeighbord = pointMatrix[x + 1][y];
        Point rightUpNeighbord = pointMatrix[x + 1][y + 1];

        Triangle triangle1 = new Triangle(point, upNeighbord, rightNeighbord);
        Triangle triangle2 = new Triangle(rightUpNeighbord, upNeighbord, rightNeighbord);

        return Arrays.asList(triangle1, triangle2);
    }
}
