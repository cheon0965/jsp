package co.yedam.app.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBeanConfig {
	@Bean
	public Chef chef() {
		return new Chef();
	}
	@Bean
	public Restaurant res(Chef chef) {
		return new Restaurant(chef);
	}
}
