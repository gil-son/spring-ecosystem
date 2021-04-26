package com.devsuperior.domainmodel.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.devsuperior.domainmodel.entities.Order;
import com.devsuperior.domainmodel.repositories.OrderRepository;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	
	@GetMapping // @GetMapping("clients") // RequestMapping care about it
	public List<Order> list(){    // JPQL from JPA
		   return repository.findAll(); // A method that comes from JPA
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id){
		Optional<Order> obj = repository.findById(id);
		// Order obj = repository.findById(id).get();
		
		if(obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		}
	
			return ResponseEntity.notFound().build();
	}	
}
	
	
