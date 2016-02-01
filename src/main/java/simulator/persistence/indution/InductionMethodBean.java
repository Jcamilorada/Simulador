package simulator.persistence.indution;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "induction_methods")
public class InductionMethodBean
{
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private double remi;
    @Column
    private double prop;
}
