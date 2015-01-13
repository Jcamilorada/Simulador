package simulator.domain.common;

public interface IBusinessObjectBeanMapper<Bean, BO>
{
    public Bean newBusinessObjectBean(final BO businessObject);

    public BO newBusinessObject(final Bean businessObjectBean);
}
