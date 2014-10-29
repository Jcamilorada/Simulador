package simulator.services.graphic.surfacemodel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SurfaceMeshDTO
{
    private Metadata metadata = new Metadata();
    private List<Double> vertices;
    private List<Long> faces;
    private List<Double> normals;
    private List<Integer> colors;
    private List<Double> uvs;
    private Double scale = 1.0;
    private List<Material> materials = new ArrayList<Material>();

    public SurfaceMeshDTO()
    {
        Material material = new Material();
        material.setVertexColors(true);
        material.setDepthTest(true);
        material.setDepthWrite(true);
        material.setShading("Lambert");
        materials.add(material);
    }

    @Data
    class Metadata
    {
        private Double formatVersion = 3.0;
        public int faces;
        private int vertices;
        private Double normals = 0.0;
        private int colors = 0;
        private Double uvs = 0.0;
        private Double materials = 1.0;
    }

    @Data
    class Material
    {
        private boolean vertexColors;
        private String shading;
        private boolean depthTest;
        private boolean depthWrite;
    }
}


