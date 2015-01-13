package simulator.domain.drug;

import org.springframework.stereotype.Component;
import simulator.common.util.StringUtil;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.drug.DrugBean;

@Component
public class DrugBeanMapper extends AbstractBusinessObjectBeanMapper<DrugBean, Drug>
{
    @Override
    public DrugBean newBusinessObjectBean(final Drug businessObject)
    {
        DrugBean drugBean = new DrugBean();
        drugBean.setDrugType(businessObject.getDrugType().getValue());
        drugBean.setId(drugBean.getId());
        drugBean.setName(drugBean.getName());
        drugBean.setConcentrations(StringUtil.getString(businessObject.getConcentrations()));

        return  drugBean;
    }

    @Override
    public Drug newBusinessObject(final DrugBean businessObjectBean)
    {
        Drug drug = new Drug();
        drug.setConcentrations(StringUtil.getIntegerList(businessObjectBean.getConcentrations()));
        drug.setId(businessObjectBean.getId());
        drug.setName(businessObjectBean.getName());
        drug.setDrugType(DrugType.fromValue(businessObjectBean.getDrugType()));
        drug.setDrugClass(DrugClass.fromDrugType(DrugType.fromValue(businessObjectBean.getDrugType())));

        return drug;
    }
}
