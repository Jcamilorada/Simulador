package simulator.restservices.parameter;

import lombok.Data;

@Data
public class ParameterDTO
{
    private long id;

    private String name;

    private String description;

    private String value;
}
