package simulator.restservices.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.solution.SolutionService;

import java.util.List;

@Controller
@RequestMapping("/solutions")
public class SolutionResource
{
    private final SolutionService solutionService;
    private final SolutionMapper solutionMapper;

    @Autowired
    SolutionResource(final SolutionService solutionService, final SolutionMapper solutionMapper)
    {
        this.solutionMapper = solutionMapper;
        this.solutionService = solutionService;
    }

    @RequestMapping public @ResponseBody List<SolutionDTO> getProcedureTypes()
    {
        return solutionMapper.newBusinessObjectDTOList(solutionService.findAll());
    }
}
