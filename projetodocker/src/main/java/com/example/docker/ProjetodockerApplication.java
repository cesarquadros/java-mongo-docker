package com.example.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProjetodockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetodockerApplication.class, args);
	}
	
	@GetMapping
	public String helloDocker() {
		return "Hello Docker!!!";
	}
}
