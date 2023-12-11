package com.example.hostelspring.repository;


import com.example.hostelspring.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Apartment findById(int id);

    List<Apartment> findAll();
}
