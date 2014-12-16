package simulator.restservices.recommendation;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class RecommendationDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String description;
}
