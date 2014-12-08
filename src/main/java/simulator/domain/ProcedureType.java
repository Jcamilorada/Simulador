package simulator.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "procedures_types")
public class ProcedureType implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String examples;

    @Column
    private Long PNR;
}
