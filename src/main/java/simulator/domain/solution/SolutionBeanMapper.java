package simulator.domain.solution;

import org.springframework.stereotype.Component;
import simulator.domain.common.AbstractBusinessObjectBeanMapper;
import simulator.persistence.solution.SolutionBean;

@Component
public class SolutionBeanMapper extends AbstractBusinessObjectBeanMapper<SolutionBean, Solution>
{
    @Override
    public SolutionBean newBusinessObjectBean(final Solution businessObject)
    {
        SolutionBean solutionBean = new SolutionBean();
        solutionBean.setDescription(businessObject.getDescription());
        solutionBean.setId(businessObject.getId());
        solutionBean.setValue(businessObject.getValue());

        return  solutionBean;
    }

    @Override
    public Solution newBusinessObject(final SolutionBean businessObjectBean)
    {
        Solution solution = new Solution();
        solution.setDescription(businessObjectBean.getDescription());
        solution.setId(businessObjectBean.getId());
        solution.setValue(businessObjectBean.getValue());

        return  solution;
    }
}
