package com.liquidbasepractice.repositories;

import com.liquidbasepractice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>
{

}
