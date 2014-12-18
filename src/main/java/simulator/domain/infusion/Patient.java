package simulator.domain.infusion;

import lombok.Data;

@Data
public class Patient
{
    private int height;
    private int weight;
    private Gender gender;
    private int age;
}
