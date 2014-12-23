package simulator.domain.drug;

import org.springframework.stereotype.Component;
import simulator.common.util.StringUtil;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.drug.DrugBean;

@Component
public class DrugBeanMapper extends AbstractBusinessObjectBeanMapper<DrugBean, Drug>
{
    @Override
    public DrugBean newBusinessObjectBean(final Drug businessObjectDTO)
    {
        DrugBean drugBean = new DrugBean();
        drugBean.setDrugType(businessObjectDTO.getDrugType().getValue());
        drugBean.setId(drugBean.getId());
        drugBean.setName(drugBean.getName());
        drugBean.setConcentrations(StringUtil.getString(businessObjectDTO.getConcentrations()));

        return  drugBean;
    }

    @Override
    public Drug newBusinessObject(final DrugBean businessObject)
    {
        Drug drug = new Drug();
        drug.setConcentrations(StringUtil.getIntegerList(businessObject.getConcentrations()));
        drug.setId(businessObject.getId());
        drug.setName(businessObject.getName());
        drug.setDrugType(DrugType.fromValue(businessObject.getDrugType()));
        drug.setDrugClass(DrugClass.fromDrugType(DrugType.fromValue(businessObject.getDrugType())));

        return drug;
    }
}
