package com.eventwithguests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventwithguests.entities.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
