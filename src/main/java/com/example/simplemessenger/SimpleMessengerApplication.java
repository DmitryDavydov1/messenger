package com.example.simplemessenger;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.simplemessenger.model")
public class SimpleMessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMessengerApplication.class, args);
	}

}
