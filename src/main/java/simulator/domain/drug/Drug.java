package simulator.domain.drug;

import lombok.Data;

import java.util.List;

@Data
public class Drug
{
    private long id;
    private String name;
    private List<Integer> concentrations;
    private DrugClass drugClass;
    private DrugType drugType;
}
