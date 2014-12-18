package simulator.domain.parameter;

import lombok.Data;

@Data
public class Parameter
{
    private long id;

    private String name;

    private String description;

    private String value;
}
