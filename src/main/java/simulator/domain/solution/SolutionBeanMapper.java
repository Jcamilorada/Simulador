package simulator.domain.solution;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.solution.SolutionBean;

@Component
public class SolutionBeanMapper extends AbstractBusinessObjectBeanMapper<SolutionBean, Solution>
{
    @Override
    public SolutionBean newBusinessObjectBean(final Solution businessObjectDTO)
    {
        SolutionBean solutionBean = new SolutionBean();
        solutionBean.setDescription(businessObjectDTO.getDescription());
        solutionBean.setId(businessObjectDTO.getId());
        solutionBean.setValue(businessObjectDTO.getValue());

        return  solutionBean;
    }

    @Override
    public Solution newBusinessObject(final SolutionBean businessObject)
    {
        Solution solution = new Solution();
        solution.setDescription(businessObject.getDescription());
        solution.setId(businessObject.getId());
        solution.setValue(businessObject.getValue());

        return  solution;
    }
}
