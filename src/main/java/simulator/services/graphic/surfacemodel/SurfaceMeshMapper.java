package simulator.services.graphic.surfacemodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;
import simulator.common.util.DoubleUtils;
import simulator.configuration.GraphicsProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
class SurfaceMeshMapper
{
    private static long MESH_BIT_MASK = 128l;

    private final GraphicsProperties graphicsProperties;

    @Autowired
    SurfaceMeshMapper(final GraphicsProperties graphicsProperties)
    {
        this.graphicsProperties = graphicsProperties;
    }

    SurfaceMeshDTO newSurfaceMeshDTO(final PointsTable points, final List<Triangle> triangles)
    {
        SurfaceMeshDTO surfaceMeshDTO = new SurfaceMeshDTO();
        surfaceMeshDTO.setVertices(getVertexList(points.getPoints()));
        surfaceMeshDTO.setFaces(getTriangleList(triangles));
        surfaceMeshDTO.setNormals(Collections.<Double>emptyList());
        surfaceMeshDTO.setColors(getColorsList(points.getPoints()));
        surfaceMeshDTO.setUvs(Collections.<Double>emptyList());
        surfaceMeshDTO.getMetadata().setFaces(surfaceMeshDTO.getFaces().size() - surfaceMeshDTO.getFaces().size() / 4);
        surfaceMeshDTO.getMetadata().setVertices(surfaceMeshDTO.getVertices().size());
        surfaceMeshDTO.getMetadata().setColors(surfaceMeshDTO.getColors().size());
        return surfaceMeshDTO;
    }

    private List<Integer> getColorsList(final List<Point> pointList)
    {
        List<Integer> colorsList = new ArrayList<>(pointList.size());
        for (Point point : pointList)
        {
            colorsList.add(point.getColor().getValue());
        }
        return colorsList;
    }

    private List<Double> getVertexList(final List<Point> pointList)
    {
        List<Double> vertexList = new ArrayList<>(pointList.size());
        for (Point point : pointList)
        {
            vertexList.add(getXValue(point));
            vertexList.add(getYValue(point));
            vertexList.add(getZValue(point));
        }
        return vertexList;
    }

    private List<Long> getTriangleList(final List<Triangle> triangleList)
    {
        List<Long> vertexList = new ArrayList<>();
        for (Triangle point : triangleList)
        {
            vertexList.add(MESH_BIT_MASK);
            //Faces
            vertexList.add(point.getVertex1().getIndex());
            vertexList.add(point.getVertex2().getIndex());
            vertexList.add(point.getVertex3().getIndex());
            //Colors
            vertexList.add(point.getVertex1().getIndex());
            vertexList.add(point.getVertex2().getIndex());
            vertexList.add(point.getVertex3().getIndex());
        }
        return vertexList;
    }

    private double getXValue(final Point point)
    {
        double value = DoubleUtils.roundDouble(point.getX(), 4) * graphicsProperties.getXFactor();
        return value - graphicsProperties.getMinRange();
    }

    private double getYValue(final Point point)
    {
        double value = DoubleUtils.roundDouble(point.getY(), 4) * graphicsProperties.getYFactor();
        return value - graphicsProperties.getMinRange();
    }

    private double getZValue(final Point point)
    {
        double value = DoubleUtils.roundDouble(point.getZ(), 4) * graphicsProperties.getZFactor();
        return value;
    }
}