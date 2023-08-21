package personalproject.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
		// ConfigurableApplicationContext context =
		// SpringApplication.run(ContentCalendarApplication.class, args);
		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		// RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		// System.err.println(restTemplate);
	}

}
