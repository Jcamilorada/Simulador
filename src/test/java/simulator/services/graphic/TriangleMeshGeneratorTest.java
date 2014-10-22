package simulator.services.graphic;

import org.junit.Assert;
import org.junit.Test;
import simulator.common.graphic.Point;
import simulator.common.graphic.Triangle;

import java.util.List;

/**
 * Data points representation of the unit test.
 *
 * p0_1 p1_1 p2_1
 * p0_0 p1_0 p2_0
 */
public class TriangleMeshGeneratorTest
{
    private TriangleMeshGenerator testInstance = new TriangleMeshGenerator();

    private Point point0_0 = new Point(0, 0, 0, 1);
    private Point point1_0 = new Point(1, 0, 4, 2);
    private Point point1_1 = new Point(1, 1, 5, 3);
    private Point point0_1 = new Point(0, 1, 2, 4);
    private Point point2_0 = new Point(2, 0, 5.5, 5);
    private Point point2_1 = new Point(2, 1, 5.3, 6);

    private Triangle triangle1 = new Triangle(point0_0, point1_0, point1_1);
    private Triangle triangle2 = new Triangle(point0_0, point1_0, point1_1);
    private Triangle triangle3 = new Triangle(point1_0, point2_0, point1_1);
    private Triangle triangle4 = new Triangle(point1_1, point2_1, point2_0);

    @Test
    public void testGetMesh()
    {
        Point[][] matrixPoint = new Point[2][2];
        matrixPoint[0][0] =  point0_0;
        matrixPoint[0][1] =  point0_1;
        matrixPoint[1][0] =  point1_0;
        matrixPoint[1][1] =  point1_1;
        matrixPoint[1][0] =  point2_0;
        matrixPoint[1][1] =  point2_1;

        List<Triangle> triangles =  testInstance.getMesh(matrixPoint);
        Assert.assertEquals("The mesh should contain two triangles", 2, triangles.size());
        verifyTriangles(triangles);
    }

    private void verifyTriangles(List<Triangle> triangles)
    {
        boolean isValid = triangles.contains(triangle1) && triangles.contains(triangle2);
        Assert.assertTrue("Generated Triangle list is wrong", isValid);
    }
}
