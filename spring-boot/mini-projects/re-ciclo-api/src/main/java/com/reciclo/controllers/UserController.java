package com.reciclo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reciclo.entities.User;
import com.reciclo.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> list(){
		return userRepository.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User add(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	
	
}
