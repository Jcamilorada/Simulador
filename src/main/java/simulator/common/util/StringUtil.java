package simulator.common.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil
{
    private static final String SEMI_COLON_REGEX = "\\s*,\\s*";

    private StringUtil()
    {
    }

    public static String getString(final List<Integer> list)
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

    public static List<Integer> getIntegerList(final String value)
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
