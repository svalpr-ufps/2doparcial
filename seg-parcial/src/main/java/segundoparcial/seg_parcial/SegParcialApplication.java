package segundoparcial.seg_parcial;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springdoc.core.models.OpenAPI;
import org.springdoc.core.models.info.Info;

@SpringBootApplication
public class SegParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegParcialApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Project Management API")
                                .version("1.0")
                                .description("API for managing projects, employees, and departments"));
    }

}

