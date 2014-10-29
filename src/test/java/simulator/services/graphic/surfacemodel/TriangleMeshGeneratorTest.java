package simulator.services.graphic.surfacemodel;

import org.junit.Assert;
import org.junit.Test;
import simulator.common.graphic.Color;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;
import simulator.services.graphic.surfacemodel.TriangleMeshGenerator;

import java.util.List;

/**
 * Data points representation of the unit test. (2 rows 3 columns)
 *
 * p5 p6
 * p3 p4
 * p1 p2
 */
public class TriangleMeshGeneratorTest
{
    private TriangleMeshGenerator testInstance = new TriangleMeshGenerator();

    private Point point1 = createRandonPoint(1);
    private Point point2 = createRandonPoint(2);
    private Point point3 = createRandonPoint(3);
    private Point point4 = createRandonPoint(4);
    private Point point5 = createRandonPoint(5);
    private Point point6 = createRandonPoint(6);

    private final Triangle triangle1 = new Triangle(point1, point2, point3);
    private final Triangle triangle2 = new Triangle(point3, point4, point5);
    private final Triangle triangle3 = new Triangle(point3, point4, point6);
    private final Triangle triangle4 = new Triangle(point4, point5, point6);

    @Test
    public void testGetMesh()
    {
        PointsTable pointsTable = new PointsTable();

        pointsTable.put(0D, 0D, point1);
        pointsTable.put(1D, 0D, point2);
        pointsTable.put(0D, 1D, point3);
        pointsTable.put(1D, 1D, point4);
        pointsTable.put(0D, 2D, point5);
        pointsTable.put(1D, 2D, point6);

        List<Triangle> triangles =  testInstance.getMesh(pointsTable, 1, 1, 0, 0, 2, 3);
        Assert.assertEquals("The mesh should contain two triangles", 4, triangles.size());
        verifyTriangles(triangles);
    }

    private void verifyTriangles(final List<Triangle> triangles)
    {
        boolean isValid = triangles.contains(triangle1) &&
            triangles.contains(triangle2) &&
            triangles.contains(triangle3) &&
            triangles.contains(triangle4);
        Assert.assertTrue("Generated Triangle list is wrong", isValid);
    }

    private Point createRandonPoint(final int index)
    {
        Color color = null;
        return new Point(0D , 0D, 0D , index, color);
    }
}
