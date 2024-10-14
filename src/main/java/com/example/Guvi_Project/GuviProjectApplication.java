package com.example.Guvi_Project;

import javax.swing.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GuviProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuviProjectApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello, DevOps World from Spring Boot!";
	}

	@GetMapping("/name")
	public String name() {
		return "Goat yaash";
	}

}
