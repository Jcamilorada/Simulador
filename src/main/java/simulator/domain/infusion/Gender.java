package simulator.domain.infusion;

import simulator.common.exceptions.EnumCastException;

public enum Gender
    {
        Male(1), Female(2);

        private int value;

        private Gender(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

        public static Gender fromValue(int value)
        {
            switch (value)
            {
                case 1:
                    return  Gender.Male;
                case 2:
                    return  Gender.Female;
                default:
                    throw new EnumCastException(value);
            }
        }
    }
