package simulator.domain.common;

import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBusinessObjectBeanMapper<Bean, Bo> implements IBusinessObjectBeanMapper<Bean, Bo>
{
    public List<Bean> newBusinessObjectBeanList(final Iterable<Bo> businessObjectList)
    {
        List<Bean> businessObjectBeanList = new ArrayList<>(Iterables.size(businessObjectList));
        for (Bo businessObject : businessObjectList)
        {
            businessObjectBeanList.add(this.newBusinessObjectBean(businessObject));
        }

        return businessObjectBeanList;
    }

    public List<Bo> newBusinessObjectList(final Iterable<Bean> businessObjectBeanList)
    {
        List<Bo> businessObjectDTOList = new ArrayList<>(Iterables.size(businessObjectBeanList));
        for (Bean businessObjectBean : businessObjectBeanList)
        {
            businessObjectDTOList.add(this.newBusinessObject(businessObjectBean));
        }

        return businessObjectDTOList;
    }
}
