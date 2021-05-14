package com.reciclo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reciclo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	
}