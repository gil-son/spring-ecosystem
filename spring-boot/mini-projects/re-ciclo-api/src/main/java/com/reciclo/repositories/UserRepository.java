package com.reciclo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
