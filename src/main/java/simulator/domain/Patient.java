package simulator.domain;

import lombok.Data;

@Data
public class Patient
{
    private int height;
    private int weight;
    private Gender gender;
    private int age;

    public static enum Gender
    {
        M(1), F(2);

        private int value;
        Gender(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

        public static Gender fromValue(int value)
        {
            return Gender.values()[value];
        }
    }
}
