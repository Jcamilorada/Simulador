package simulator.domain.recomendation;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Recommendation implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column
    private String description;
}
