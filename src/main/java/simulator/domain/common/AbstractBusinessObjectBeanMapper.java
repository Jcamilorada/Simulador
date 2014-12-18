package simulator.domain.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBusinessObjectBeanMapper<Bean, Bo> implements IBusinessObjectBeanMapper<Bean, Bo>
{
    public List<Bean> newBusinessObjectBeanList(final List<Bo> businessObjectList)
    {
        List<Bean> businessObjectBeanList = new ArrayList<>(businessObjectList.size());
        for (Bo businessObject : businessObjectList)
        {
            businessObjectBeanList.add(this.newBusinessObjectBean(businessObject));
        }

        return businessObjectBeanList;
    }

    public List<Bo> newBusinessObjectList(final List<Bean> businessObjectBeanList)
    {
        List<Bo> businessObjectDTOList = new ArrayList<>(businessObjectBeanList.size());
        for (Bean businessObjectBean : businessObjectBeanList)
        {
            businessObjectDTOList.add(this.newBusinessObject(businessObjectBean));
        }

        return businessObjectDTOList;
    }
}
