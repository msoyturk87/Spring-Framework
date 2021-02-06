package com.cybertek;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestopenapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestopenapiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi(){

		return new OpenAPI()
				.info(new Info().title("Cinema Application")
						.version("v1")
						.description("Selling online cinema tickets"));
	}

}
