package com.devsuperior.domainmodel.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.domainmodel.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}
