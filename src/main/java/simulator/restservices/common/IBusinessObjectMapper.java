package simulator.restservices.common;

import java.util.List;

public interface IBusinessObjectMapper<T, DTO>
{
    public T newBusinessObject(final DTO businessObjectDTO);

    public DTO newBusinessObjectDTO(final T businessObject);

    public List<T> newBusinessObjectList(final List<DTO> businessObjectDTO);

    public List<DTO> newBusinessObjectDTOList(final List<T> businessObjectList);
}
