package com.example.IRCTC.Repositories;

import com.example.IRCTC.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
