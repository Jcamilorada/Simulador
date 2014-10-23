package simulator.services.graphic;

import lombok.Data;
import simulator.common.graphic.Point;
import simulator.common.graphic.Triangle;

import java.util.List;

@Data
public final class SurfaceMeshDTO
{
    public List<Triangle> triangleList;
    public List<Point> pointList;
}
