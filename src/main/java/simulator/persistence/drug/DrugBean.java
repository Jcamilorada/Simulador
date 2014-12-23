package simulator.persistence.drug;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity()
@Table(name = "drugs")
public class DrugBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Column
    private String name;
    @Column(name = "drug_type")
    private int drugType;
    @Column
    private String concentrations;
}
