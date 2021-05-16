package com.reciclo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.reciclo.entities.Address;
import com.reciclo.repositories.AddressRepository;


@RestController
@RequestMapping(value="/address")
public class AddressController {

	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	public List<Address> list(){
		return addressRepository.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Address add(@RequestBody Address address) {
		
		return addressRepository.save(address);
		
	}
	
	@GetMapping("/{addressId}") // @GetMapping("/clients/{clientId}")
	public ResponseEntity<Address> search(@PathVariable Integer addressId) {
		Optional<Address> address = addressRepository.findById(addressId);
		
		if(address.isPresent()) {
			return ResponseEntity.ok(address.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}