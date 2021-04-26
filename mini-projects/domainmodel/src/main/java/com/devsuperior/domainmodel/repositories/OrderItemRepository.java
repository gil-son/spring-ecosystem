package com.devsuperior.domainmodel.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.domainmodel.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}