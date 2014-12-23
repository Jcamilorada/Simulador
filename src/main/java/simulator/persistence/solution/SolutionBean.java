package simulator.persistence.solution;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "solutions")
public class SolutionBean
{
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column
    private String description;
    @Column
    private int value;
}
