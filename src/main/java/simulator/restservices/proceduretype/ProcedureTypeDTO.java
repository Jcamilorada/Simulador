package simulator.restservices.proceduretype;

import lombok.Data;

@Data
public class ProcedureTypeDTO
{
    private Long id;

    private String name;

    private String examples;

    private Long PNR;
}
