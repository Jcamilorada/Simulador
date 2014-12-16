package simulator.common;

import com.sun.javafx.tools.ant.Platform;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Juan Camilo Rada
 *
 * Generic Mapper used to object to object mapping.
 */
@Component
public class ObjectMapper
{
    private final ModelMapper modelMapper = new ModelMapper();

    public <D> D map(final Object source, final Class<D> destinationType)
    {
        return modelMapper.map(source, destinationType);
    }

    public <D> List<D> mapList(final List<?> source, final Class<D> destinationType)
    {
        List<D> result = new ArrayList<>(source.size());
        for (Object object : source)
        {
            result.add(modelMapper.map(object, destinationType));
        }
        return result;
    }
}
