package simulator.dto;

import lombok.Data;

/**
* Created by juan on 15/12/14.
*/
@Data
public class Metadata
{
    private Double formatVersion = 3.0;
    public int faces;
    private int vertices;
    private Double normals = 0.0;
    private int colors = 0;
    private Double uvs = 0.0;
    private Double materials = 1.0;
}
