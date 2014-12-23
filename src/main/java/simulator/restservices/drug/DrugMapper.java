package simulator.restservices.drug;

import org.springframework.stereotype.Component;
import simulator.domain.drug.Drug;
import simulator.domain.drug.DrugType;
import simulator.domain.drug.DrugClass;
import simulator.restservices.common.AbstractBusinessObjectMapper;

@Component
public class DrugMapper extends AbstractBusinessObjectMapper<Drug, DrugDTO>
{
    @Override
    public Drug newBusinessObject(final DrugDTO businessObjectDTO)
    {
        Drug drug = new Drug();
        drug.setId(businessObjectDTO.getId());
        drug.setDrugType(DrugType.fromValue(businessObjectDTO.getDrugType()));
        drug.setDrugClass(DrugClass.fromDrugType(drug.getDrugType()));
        drug.setConcentrations(businessObjectDTO.getConcentrations());

        return drug;
    }

    @Override
    public DrugDTO newBusinessObjectDTO(final Drug businessObject)
    {
        DrugDTO drugDTO = new DrugDTO();
        drugDTO.setId(businessObject.getId());
        drugDTO.setDrugType(businessObject.getDrugType().getValue());
        drugDTO.setConcentrations(businessObject.getConcentrations());
        drugDTO.setName(businessObject.getName());

        return drugDTO;
    }
}
