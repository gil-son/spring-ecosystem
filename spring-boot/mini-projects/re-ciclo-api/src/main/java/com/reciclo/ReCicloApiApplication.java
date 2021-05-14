package com.reciclo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reciclo.entities.Address;
import com.reciclo.entities.User;
import com.reciclo.repositories.AddressRepository;
import com.reciclo.repositories.UserRepository;

@SpringBootApplication
public class ReCicloApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReCicloApiApplication.class, args);
	}
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public void run(String ...args) throws Exception{
		Date date = new Date(System.currentTimeMillis());
		
		Address address = new Address(null,"Street A",0001,"Complement A","District A","Locality A","State A",01);
		Address address2 = new Address(null,"Street B",0002,"Complement B","District B","Locality B","State B",02);
		
		User user = new User(null, "Fulano A", 1, "fulanoa@gmail.com", "3333-3333", "123456",address, date);
		User user2 = new User(null, "Fulano B", 2, "fulanob@gmail.com", "3333-3333", "123456",address2, date);
		
		addressRepository.saveAll(Arrays.asList(address, address2));
		userRepository.saveAll((Arrays.asList(user, user2)));
		
	}
	
}
