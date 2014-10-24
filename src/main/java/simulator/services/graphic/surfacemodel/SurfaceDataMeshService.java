package simulator.services.graphic.surfacemodel;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simulator.common.graphic.PointsTable;
import simulator.common.graphic.Triangle;
import simulator.configuration.GraphicsProperties;

import java.util.List;

@Component
public class SurfaceDataMeshService implements ISurfaceDataMeshService
{
    private final SurfaceModelCalculator surfaceModelCalculator;

    private final TriangleMeshGenerator triangleMeshGenerator;

    private final GraphicsProperties graphicsProperties;

    private final SurfaceMeshMapper surfaceMeshMapper;

    @Autowired
    SurfaceDataMeshService(
        final SurfaceModelCalculator surfaceModelCalculator,
        final TriangleMeshGenerator triangleMeshGenerator,
        final GraphicsProperties graphicsProperties,
        final SurfaceMeshMapper surfaceMeshMapper)
    {
        this.surfaceModelCalculator = Preconditions.checkNotNull(surfaceModelCalculator);
        this.triangleMeshGenerator = Preconditions.checkNotNull(triangleMeshGenerator);
        this.graphicsProperties = Preconditions.checkNotNull(graphicsProperties);
        this.surfaceMeshMapper = Preconditions.checkNotNull(surfaceMeshMapper);
    }

    @Override
    public SurfaceMeshDTO getSurfaceMeshDTO()
    {
        PointsTable points = surfaceModelCalculator.generateDataPoints(0.1D, 0.1D, 10, 10);
        List<Triangle> triangles = triangleMeshGenerator.getMesh(points, 0.1D, 0.1D, 10, 10);

        SurfaceMeshDTO surfaceMeshDTO = surfaceMeshMapper.newSurfaceMeshDTO(points, triangles);
        return surfaceMeshDTO;
    }
}
