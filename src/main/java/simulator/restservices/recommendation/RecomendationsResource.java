package simulator.restservices.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.recomendation.IRecommendationService;
import simulator.domain.recomendation.Recommendation;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recommendations")
public class RecomendationsResource
{
    private final IRecommendationService recommendationService;
    private final RecomendationMapper recomendationMapper;

    @Autowired
    RecomendationsResource(final IRecommendationService parameterService,
                           final RecomendationMapper recomendationMapper)
    {
        this.recommendationService = parameterService;
        this.recomendationMapper = recomendationMapper;
    }

    @RequestMapping
    public
    @ResponseBody
    List<RecommendationDTO> getRecomendations()
    {
        return  getRecomendations(recommendationService.getRecomendations());
    }

    private List<RecommendationDTO> getRecomendations(final List<Recommendation> recommendations)
    {
        List<RecommendationDTO> dtoList = new ArrayList<>(recommendations.size());
        for (Recommendation recommendation : recommendations)
        {
            dtoList.add(recomendationMapper.newBusinessObjectDTO(recommendation));
        }

        return  dtoList;
    }
}

