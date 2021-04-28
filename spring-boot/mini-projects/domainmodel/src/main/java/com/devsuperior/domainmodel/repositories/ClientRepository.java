package com.devsuperior.domainmodel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.domainmodel.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{ // Exist Generic Repository
	
}
