package simulator.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
    public class Material
    {
        private boolean vertexColors;
        private String shading;
        private boolean depthTest;
        private boolean depthWrite;
    }
}


