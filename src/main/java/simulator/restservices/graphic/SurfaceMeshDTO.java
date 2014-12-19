package simulator.restservices.graphic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class SurfaceMeshDTO
{
    private MetadataDTO metadataDTO = new MetadataDTO();
    private List<Double> vertices;
    private List<Long> faces;
    private List<Double> normals;
    private List<Integer> colors;
    private List<Double> uvs;
    private Double scale = 1.0;
    private List<MaterialDTO> materials = new ArrayList<MaterialDTO>();

    public SurfaceMeshDTO()
    {
        MaterialDTO material = new MaterialDTO();
        material.setVertexColors(true);
        material.setDepthTest(true);
        material.setDepthWrite(true);
        material.setShading("Lambert");
        materials.add(material);
    }

    @Data
    public class MaterialDTO
    {
        private boolean vertexColors;
        private String shading;
        private boolean depthTest;
        private boolean depthWrite;
    }

    @Data
    public class MetadataDTO
    {
        private Double formatVersion = 3.0;
        public int faces;
        private int vertices;
        private Double normals = 0.0;
        private int colors = 0;
        private Double uvs = 0.0;
        private Double materials = 1.0;
    }
}


