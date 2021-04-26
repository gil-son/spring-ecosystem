package com.devsuperior.domainmodel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.domainmodel.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
