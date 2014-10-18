package simulator.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"simulator.restservices", "simulator.services"})
@EnableJpaRepositories(basePackages = "simulator.persistence")
@EntityScan(basePackages = "simulator.domain")
public class Application
{
    public static void main(String... args)
    {
        SpringApplication.run(Application.class, args);
    }
}