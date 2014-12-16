package simulator.domain.systemparameter;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class SystemParameter
{
    private long id;

    private String name;

    private String description;

    private String value;
}
