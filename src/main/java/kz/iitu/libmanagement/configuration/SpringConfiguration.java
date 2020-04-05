package kz.iitu.libmanagement.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan(basePackages = "kz.iitu.libmanagement")
@PropertySource("application.properties")

public class SpringConfiguration {
}

