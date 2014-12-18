package simulator.restservices.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBusinessObjectMapper<T, DTO> implements IBusinessObjectMapper<T, DTO>
{
    public List<T> newBusinessObjectList(final List<DTO> businessObjectDTO)
    {
        List<T> businessObjectList = new ArrayList<>(businessObjectDTO.size());
        for (DTO dto : businessObjectDTO)
        {
            businessObjectList.add(this.newBusinessObject(dto));
        }

        return businessObjectList;
    }

    public List<DTO> newBusinessObjectDTOList(final List<T> businessObjectList)
    {
        List<DTO> businessObjectDTOList = new ArrayList<>(businessObjectList.size());
        for (T businessObject : businessObjectList)
        {
            businessObjectDTOList.add(this.newBusinessObjectDTO(businessObject));
        }

        return businessObjectDTOList;
    }
}
