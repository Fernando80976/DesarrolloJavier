package goya.daw2.pruebas_plantillas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("goya.daw2.entities")                // <- aquí indicamos donde están las entidades
@EnableJpaRepositories("goya.daw2.repositories") // <- aquí indicamos donde están los repositorios

public class FormulariosEncadenadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormulariosEncadenadosApplication.class, args);
	}

}
