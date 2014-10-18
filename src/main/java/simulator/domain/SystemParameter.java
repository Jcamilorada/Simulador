package simulator.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "systemparameter")
public class SystemParameter implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String value;
}
