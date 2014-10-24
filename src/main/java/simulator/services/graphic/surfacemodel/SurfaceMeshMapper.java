package simulator.services.graphic.surfacemodel;

import simulator.common.graphic.Point;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SurfaceMeshMapper
{
    SurfaceMeshDTO newSurfaceMeshDTO(PointsTable points, List<Triangle> triangles)
    {
        SurfaceMeshDTO surfaceMeshDTO = new SurfaceMeshDTO();
        surfaceMeshDTO.setVertices(getVertexList(points.getPoints()));
        surfaceMeshDTO.setFaces(getTriangleList(triangles));
        surfaceMeshDTO.setNormals(Collections.<Double>emptyList());
        surfaceMeshDTO.setColors(Collections.<Double>emptyList());
        surfaceMeshDTO.getMetadata().setFaces(surfaceMeshDTO.getFaces().size());
        surfaceMeshDTO.getMetadata().setVertices(surfaceMeshDTO.getVertices().size());

        return surfaceMeshDTO;
    }

    private List<Double> getVertexList(List<Point> pointList)
    {
        List<Double> vertexList = new ArrayList<Double>();
        for (Point point : pointList)
        {
            vertexList.add(point.getX());
            vertexList.add(point.getY());
            vertexList.add(point.getZ());
        }
        return vertexList;
    }

    public List<Long> getTriangleList(List<Triangle> triangleList)
    {
        List<Long> vertexList = new ArrayList<Long>();
        for (Triangle point : triangleList)
        {
            vertexList.add(point.getVertex1().getIndex());
            vertexList.add(point.getVertex2().getIndex());
            vertexList.add(point.getVertex3().getIndex());
        }
        return vertexList;
    }
}
