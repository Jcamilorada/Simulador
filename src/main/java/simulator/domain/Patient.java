package simulator.domain;

import lombok.Data;

@Data
public class Patient
{
    private int height;
    private int weight;
    private Gender gender;
    private int age;

    static enum Gender {M, F}
}
