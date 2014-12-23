package simulator.restservices.drug;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
public class DrugDTO
{
    private long id;
    private String name;
    private int drugType;
    private List<Integer> concentrations;
}
