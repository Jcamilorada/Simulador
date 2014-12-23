package simulator.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alevalv on 23/12/2014.
 */
@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "pump")
public class PumpProperties
{
    private double minimumInfusion;

    private double maximumInfusion;

    private int maximumTime;

    private double epsilon;
}
