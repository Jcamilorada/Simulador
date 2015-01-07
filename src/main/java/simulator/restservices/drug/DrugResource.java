package simulator.restservices.drug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.drug.DrugService;
import simulator.domain.drug.DrugType;

import java.util.List;

@Controller
public class DrugResource
{
    private final DrugService drugService;
    private final DrugMapper drugMapper;

    @Autowired
    DrugResource(final DrugService drugService, final DrugMapper drugMapper)
    {
        this.drugService = drugService;
        this.drugMapper = drugMapper;
    }

    @RequestMapping("/drugs/type/{type}")
    public @ResponseBody List<DrugDTO> getDrugs(@PathVariable int type)
    {
        return drugMapper.newBusinessObjectDTOList(
            drugService.findAllByType(DrugType.fromValue(type)));
    }
}
