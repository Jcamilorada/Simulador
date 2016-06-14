package simulator.restservices.drug;

import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.drug.Drug;
import simulator.persistence.drug.DrugRepository;

@Controller
public class DrugResource
{
    private final DrugRepository drugRepository;

    @Autowired
    DrugResource(final DrugRepository drugRepository)
    {
        this.drugRepository = Preconditions.checkNotNull(drugRepository);
    }

    @RequestMapping("/drugs/type/{type}")
    public @ResponseBody List<Drug> getDrugs(@PathVariable int type)
    {
        return drugRepository.findByDrugType(type);
    }
}
