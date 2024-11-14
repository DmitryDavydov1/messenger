package com.example.simplemessenger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SimpleMessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMessengerApplication.class, args);
	}

}
