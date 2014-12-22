package simulator.persistence.parameter;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "parameters")
public class ParameterBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String value;
}
