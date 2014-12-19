package simulator.restservices.common;

import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Map beetween Business Object and DTO Business Object.
 */
public interface IBusinessObjectMapper<T, DTO>
{
    public T newBusinessObject(final DTO businessObjectDTO);

    public DTO newBusinessObjectDTO(final T businessObject);

    public List<T> newBusinessObjectList(final List<DTO> businessObjectDTO);

    public List<DTO> newBusinessObjectDTOList(final List<T> businessObjectList);
}
