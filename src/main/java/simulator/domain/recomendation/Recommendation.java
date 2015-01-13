package simulator.domain.recomendation;

import lombok.Data;

import java.util.List;

@Data
public class Recommendation
{
    private Long id;
    private String description;
    private RecommendationType recommendationType;
    private List<String> alternatives;
    private SentenceType sentenceType;
}
