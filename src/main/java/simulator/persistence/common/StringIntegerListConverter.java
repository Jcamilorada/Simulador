package simulator.persistence.common;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeConverter;

/**
 *
 *
 * @author Juan Camilo Rada
 */
public class StringIntegerListConverter implements AttributeConverter<List<Integer>, String>
{
    private static final String SEMI_COLON_REGEX = "\\s*,\\s*";

    @Override
    public String convertToDatabaseColumn(List<Integer> list)
    {
        List<String> trimmed = Lists.transform(list, new Function<Integer, String>()
        {
            @Override
            public String apply(Integer in)
            {
                return String.valueOf(in);
            }
        });
        String joined = Joiner.on(",").join(trimmed);
        return joined;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String value)
    {
        String[] arrayValues = value.split(SEMI_COLON_REGEX);

        List<Integer> values = new ArrayList<>(arrayValues.length);
        for (String string : arrayValues)
        {
            values.add(Integer.valueOf(string));
        }
        return  values;
    }
}
