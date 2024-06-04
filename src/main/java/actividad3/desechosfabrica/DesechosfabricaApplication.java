package actividad3.desechosfabrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "actividad3.desechosfabrica.models.repositories")
@EntityScan(basePackages = "actividad3.desechosfabrica.models.entities")
public class DesechosfabricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesechosfabricaApplication.class, args);
	}

}
