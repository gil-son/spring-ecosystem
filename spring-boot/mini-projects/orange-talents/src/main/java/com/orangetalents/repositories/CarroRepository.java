package com.orangetalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	// public Carro getByCarro(Integer carro);
}
