package com.example.hostelspring.service.impl;

import com.example.hostelspring.model.Apartment;
import com.example.hostelspring.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApartmentServiceImpl {

    private final ApartmentRepository apartmentRepository;


    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    public Apartment findById(int id) {
        return apartmentRepository.findById(id);
    }

}

