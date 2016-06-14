package simulator.restservices.recommendation;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.persistence.recommendation.RecommendationBean;
import simulator.persistence.recommendation.RecommendationRepository;

@Controller
@RequestMapping("/recommendations")
public class RecomendationsResource
{
    private final RecommendationRepository recommendationRepository;

    @Autowired
    RecomendationsResource(RecommendationRepository recommendationRepository)
    {
        this.recommendationRepository =
                Preconditions.checkNotNull(recommendationRepository, "recommendationRepository cannot be null");
    }

    @RequestMapping("/type/{type}")
    public @ResponseBody List<RecommendationBean> getRecomendations(@PathVariable int type)
    {
        return Lists.newArrayList(recommendationRepository.findAll());
    }
}

