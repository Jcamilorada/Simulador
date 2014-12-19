package simulator.restservices.infusion;

import lombok.Data;

/**
 * @author Juan Camilo Rada
 *
 * Patient information data transfer object.
 */
@Data
public class PatientDTO
{
    private int height;
    private int weight;
    private int age;
    private int gender;
}
