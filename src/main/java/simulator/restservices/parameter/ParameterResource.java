package simulator.restservices.parameter;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.parameter.ParameterBean;
import simulator.persistence.parameter.ParameterRepository;

/**
 * @author Juan Camilo Rada
 *
 * System parameters resource. Provide paremters information to the ui.
 */
@Controller
public class ParameterResource
{
    private final ParameterRepository parameterRepository;

    @Autowired
    ParameterResource(final ParameterRepository parameterRepository)
    {
        this.parameterRepository = Preconditions.checkNotNull(parameterRepository, "parameterRepository cannot be null");
    }

    @RequestMapping("/parameters/{id}")
    public
    @ResponseBody
    ParameterBean getParameter(final @PathVariable long id)
    {
        return parameterRepository.findOne(id);
    }
}