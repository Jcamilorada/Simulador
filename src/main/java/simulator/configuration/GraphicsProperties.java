package simulator.configuration;


import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "graphics")
public class GraphicsProperties
{

    @Getter(AccessLevel.PUBLIC)
    private Double interval;


    @Getter(AccessLevel.PUBLIC)
    private Double maxRange;
}
