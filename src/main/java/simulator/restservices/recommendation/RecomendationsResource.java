package simulator.restservices.recommendation;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.recomendation.IRecommendationService;

import java.util.List;

@Controller
@RequestMapping("/recommendations")
public class RecomendationsResource
{
    private final IRecommendationService recommendationService;
    private final RecommendationMapper recommendationMapper;

    @Autowired
    RecomendationsResource(final IRecommendationService parameterService,
                           final RecommendationMapper recommendationMapper)
    {
        this.recommendationService = Preconditions.checkNotNull(parameterService, "recommendationService cannot be null");
        this.recommendationMapper = Preconditions.checkNotNull(recommendationMapper, "recomendationMapper cannot be null" );
    }

    @RequestMapping("/type/{type}")
    public @ResponseBody List<RecommendationDTO> getRecomendations(@PathVariable int type)
    {
        return  recommendationMapper.newBusinessObjectDTOList(
            recommendationService.getRecommendations(type));
    }
}

