package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","dao","service"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"dao"})
public class MicroservicioCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCounterApplication.class, args);
	}

	
}
