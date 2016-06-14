package simulator.persistence.drug;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import simulator.persistence.common.StringIntegerListConverter;

@Data
@Entity()
@Table(name = "drugs")
public class Drug implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column
    private String name;

    @Column(name = "drug_type")
    private int drugType;

    @Column
    @Convert(converter = StringIntegerListConverter.class)
    private List<Integer> concentrations;
}
