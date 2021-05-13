package com.reciclo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reciclo.entities.User;
import com.reciclo.repositories.UserRepository;

@SpringBootApplication
public class ReCicloApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReCicloApiApplication.class, args);
	}
	
	
	@Autowired
	UserRepository userRepository;

	public void run(String ...args) throws Exception{
		
		Date date = new Date(System.currentTimeMillis());
		User user = new User(null,"Fulano A",1,"fulanoa@gmail.com","3333-3333","123456",date);
		User user2 = new User(null,"Fulano B",2,"fulanob@gmail.com","3333-3333","123456",date);
		
		
		userRepository.saveAll((Arrays.asList(user, user2)));
		
	}
	
}
