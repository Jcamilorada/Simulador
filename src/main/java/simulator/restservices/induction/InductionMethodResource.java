package simulator.restservices.induction;

import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.indution.InductionMethodBean;
import simulator.persistence.indution.InductionMethodRepository;

/**
 * @author Juan Camilo Rada
 */
@Controller
public class InductionMethodResource
{
    private final InductionMethodRepository inductionMethodRepository;

    @Autowired
    InductionMethodResource(final InductionMethodRepository inductionMethodRepository)
    {
        this.inductionMethodRepository = Preconditions.checkNotNull(inductionMethodRepository);
    }

    @RequestMapping("/methods")
    public @ResponseBody List<InductionMethodBean> getInductionMethods()
    {
        return inductionMethodRepository.findAll();
    }
}
