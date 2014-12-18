package simulator.domain.common;

public interface IBusinessObjectBeanMapper<Bean, BO>
{
    public Bean newBusinessObjectBean(final BO businessObjectDTO);

    public BO newBusinessObject(final Bean businessObject);
}
