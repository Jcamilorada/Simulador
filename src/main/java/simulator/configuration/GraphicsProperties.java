package simulator.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "graphics")
public class GraphicsProperties
{
    private double interval;

    private double maxRange;

    private double minRange;

    /* x Factor used to change x values in the mesh. */
    private int xFactor;

    /* y Factor used to change y values in the mesh. */
    private int yFactor;

    /* z Factor used to change z values in the mesh. */
    private int zFactor;
}
