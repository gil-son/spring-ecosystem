package com.orangetalents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orangetalents.entities.Carro;
import com.orangetalents.entities.Usuario;
import com.orangetalents.repositories.CarroRepository;
import com.orangetalents.repositories.UsuarioRepository;

@SpringBootApplication
public class OrangeTalentsApplication implements CommandLineRunner{

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Carro carro = new Carro(null, "Marca A", "Modelo A", 1990, 10.000, true);
		Carro carro2 = new Carro(null, "Marca B", "Modelo B", 1995, 15.000, true);
		Carro carro3 = new Carro(null, "Marca C", "Modelo C", 2000, 20.000, false);
		
		
		List<Carro> carros = new ArrayList<>();
		carros.add(carro);	carros.add(carro2);
		
		List<Carro> carros2 = new ArrayList<>();
		carros2.add(carro3);
		
		Date date = new Date(System.currentTimeMillis());
		
		Usuario usuario = new Usuario(null,"Nome A","email_a@gmail.com","0500-000", carros, date);
		Usuario usuario2 = new Usuario(null,"Nome B","email_b@gmail.com","0550-000", carros2, date);
		
		carroRepository.saveAll(Arrays.asList(carro, carro2, carro3));
		
		usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
	}

	
	
}
