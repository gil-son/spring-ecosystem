package com.liquidbasepractice.repositories;

import com.liquidbasepractice.entities.Someone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeoneRepository extends JpaRepository<Someone, Integer>
{

}
