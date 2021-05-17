package com.orangetalents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.entities.Carro;
import com.orangetalents.entities.Usuario;
import com.orangetalents.repositories.CarroRepository;

@RestController
@RequestMapping(value="/carros")
public class CarroController {

	@Autowired
	CarroRepository carroRepository;
	
	@GetMapping
	public List<Carro> listCar() {
		return carroRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carro addUsuario(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
}
