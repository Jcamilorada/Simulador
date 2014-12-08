package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.Recommendation;
import simulator.services.recomendations.IRecommendationService;

import java.util.List;

@Controller
@RequestMapping("/recommendations")
public class RecomendationsController
{
    private IRecommendationService recommendationService;

    @Autowired
    RecomendationsController(IRecommendationService parameterService)
    {
        this.recommendationService = parameterService;
    }

    @RequestMapping
    public
    @ResponseBody
    List<Recommendation> getRecomendations()
    {
        return recommendationService.getRecomendations();
    }
}

