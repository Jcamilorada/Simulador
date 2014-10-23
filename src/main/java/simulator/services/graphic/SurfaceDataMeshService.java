package simulator.services.graphic;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;

import java.util.List;

@Component
public class SurfaceDataMeshService implements ISurfaceDataMeshService
{
    private final SurfaceModelCalculator surfaceModelCalculator;

    private final TriangleMeshGenerator triangleMeshGenerator;

    @Autowired
    SurfaceDataMeshService(
        final SurfaceModelCalculator surfaceModelCalculator, final TriangleMeshGenerator triangleMeshGenerator)
    {
        this.surfaceModelCalculator = Preconditions.checkNotNull(surfaceModelCalculator);
        this.triangleMeshGenerator = Preconditions.checkNotNull(triangleMeshGenerator);
    }

    @Override
    public SurfaceMeshDTO getSurfaceMeshDTO()
    {
        PointsTable points = surfaceModelCalculator.generateDataPoints(0.5D, 0.5D, 10, 10);
        List<Triangle> triangles = triangleMeshGenerator.getMesh(points, 0.5D, 0.5D, 10, 10);

        SurfaceMeshDTO surfaceMeshDTO = buildSurfaceMeshDTO(points, triangles);
        return surfaceMeshDTO;
    }

    private SurfaceMeshDTO buildSurfaceMeshDTO(final PointsTable points, final List<Triangle> triangles)
    {
        SurfaceMeshDTO surfaceMeshDTO = new SurfaceMeshDTO();
        surfaceMeshDTO.setPointList(points.getPoints());
        surfaceMeshDTO.setTriangleList(triangles);

        return surfaceMeshDTO;
    }
}
