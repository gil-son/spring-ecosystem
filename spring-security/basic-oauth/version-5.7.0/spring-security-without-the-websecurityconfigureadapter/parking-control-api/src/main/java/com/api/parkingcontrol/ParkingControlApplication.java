package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
		// The correct thing is to create a rest endpoint to register a new user and password
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));

	}

	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}
}
