package simulator.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author alevalv.
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

    /* Number of rounded decimal places to send data to the ui side. */
    private int decimalPlaces;
}
