package simulator.domain.procedurestypes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class ProcedureType
{
    private Long id;

    private String name;

    private String examples;

    private Long PNR;
}
