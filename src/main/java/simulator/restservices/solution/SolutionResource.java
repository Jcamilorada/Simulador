package simulator.restservices.solution;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.solution.SolutionBean;
import simulator.persistence.solution.SolutionRepository;

@Controller
@RequestMapping("/solutions")
public class SolutionResource
{
    private final SolutionRepository solutionRepository;

    @Autowired
    SolutionResource(final SolutionRepository solutionRepository)
    {
        this.solutionRepository = solutionRepository;
    }

    @RequestMapping public @ResponseBody List<SolutionBean> getProcedureTypes()
    {
        return Lists.newArrayList(solutionRepository.findAll());
    }
}
