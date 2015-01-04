package simulator.restservices.induction;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.induction.InductionMethodService;

import java.util.List;

/**
 * @author Juan Camilo Rada
 */
@Controller
public class InductionMethodResource
{
    private final InductionMethodService inductionMethodService;
    private final InductionMethodMapper inductionMethodMapper;

    @Autowired
    InductionMethodResource(
        final InductionMethodService inductionMethodService, final InductionMethodMapper inductionMethodMapper)
    {
        this.inductionMethodService = Preconditions.checkNotNull(inductionMethodService);
        this.inductionMethodMapper = Preconditions.checkNotNull(inductionMethodMapper);
    }

    @RequestMapping("/methods")
    public @ResponseBody List<InductionMethodDTO> getInductionMethods()
    {
        return inductionMethodMapper.newBusinessObjectDTOList(inductionMethodService.getInductionMethods());
    }
}
