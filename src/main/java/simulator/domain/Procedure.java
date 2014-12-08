package simulator.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "procedures")
public class Procedure implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private String code;

    @Column
    private String name;
}
