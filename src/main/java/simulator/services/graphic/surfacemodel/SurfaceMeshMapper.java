package simulator.services.graphic.surfacemodel;
import org.springframework.stereotype.Component;
import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;
import simulator.common.util.ColorUtils;
import simulator.common.util.DoubleUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
 class SurfaceMeshMapper
{
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
        List<Integer> colorsList = new ArrayList<Integer>();
        for (Point point : pointList)
        {
            colorsList.add(point.getColor().getValue());
        }
        return colorsList;
    }

    private List<Double> getVertexList(final List<Point> pointList)
    {
        List<Double> vertexList = new ArrayList<Double>();
        for (Point point : pointList)
        {
            vertexList.add(DoubleUtils.roundDouble(point.getX(), 4) * 5);
            vertexList.add(DoubleUtils.roundDouble(point.getY(), 4) * 5);
            vertexList.add(DoubleUtils.roundDouble(point.getZ(), 4) * 10);
        }
        return vertexList;
    }

    public List<Long> getTriangleList(final List<Triangle> triangleList)
    {
        List<Long> vertexList = new ArrayList<>();
        for (Triangle point : triangleList)
        {
            vertexList.add(128l);
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
}