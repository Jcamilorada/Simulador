package simulator.services.graphic.surfacemodel;

import lombok.Data;
import simulator.common.graphic.Point;
import simulator.common.graphic.Triangle;

import java.math.BigDecimal;
import java.util.List;

@Data
public final class SurfaceMeshDTO
{
    private Metadata metadata = new Metadata();
    private List<Long> faces;
    private List<Double> vertices;
    private List<Double> normals;
    private List<Double> colors;
    private Double scale = 1.0;

    @Data
    class Metadata
    {
        private Double formatVersion = 3.0;
        public int faces;
        private int vertices;
        private Double normals = 0.0;
        private Double materials = 0.0;
    }

}


