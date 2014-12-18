package simulator.domain.procedurestype;

import lombok.Data;

@Data
public class ProcedureType
{
    private Long id;

    private String name;

    private String examples;

    private Long PNR;
}
