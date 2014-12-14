package simulator.dto;

import lombok.Data;

@Data
public class PatientDTO
{
    private int height;
    private int weight;
    private int age;
    /* 0 M - F 1 */
    private int gender;
}
