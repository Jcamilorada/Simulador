package simulator.restservices.solution;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.domain.solution.Solution;
import simulator.persistence.solution.SolutionBean;
import simulator.restservices.common.AbstractBusinessObjectMapper;

@Component
public class SolutionMapper extends AbstractBusinessObjectMapper<Solution, SolutionDTO>
{
    @Override
    public Solution newBusinessObject(final SolutionDTO businessObjectDTO)
    {
        Solution Solution = new Solution();
        Solution.setDescription(businessObjectDTO.getDescription());
        Solution.setId(businessObjectDTO.getId());
        Solution.setValue(businessObjectDTO.getValue());

        return  Solution;
    }

    @Override
    public SolutionDTO newBusinessObjectDTO(final Solution businessObject)
    {
        SolutionDTO solutionBean = new SolutionDTO();
        solutionBean.setDescription(businessObject.getDescription());
        solutionBean.setId(businessObject.getId());
        solutionBean.setValue(businessObject.getValue());

        return  solutionBean;
    }
}
