package personalproject.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyWebConfig {
    // @Component - a class level
    @Bean // a method level
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

}
