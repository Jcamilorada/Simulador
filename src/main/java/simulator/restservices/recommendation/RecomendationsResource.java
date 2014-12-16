package simulator.restservices.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.common.ObjectMapper;
import simulator.domain.recomendations.Recommendation;
import simulator.domain.recomendations.IRecommendationService;

import java.util.List;

@Controller
@RequestMapping("/recommendations")
public class RecomendationsResource
{
    private final IRecommendationService recommendationService;
    private final ObjectMapper objectMapper;

    @Autowired
    RecomendationsResource(final IRecommendationService parameterService,
                           final ObjectMapper objectMapper)
    {
        this.recommendationService = parameterService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping
    public
    @ResponseBody
    List<RecommendationDTO> getRecomendations()
    {
        return objectMapper.mapList(
            recommendationService.getRecomendations(), RecommendationDTO.class);
    }
}

