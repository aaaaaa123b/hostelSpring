package com.example.hostelspring.service.impl;

import com.example.hostelspring.model.Hostel;
import com.example.hostelspring.repository.HostelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HostelServiceImpl {
    private final HostelRepository hostelRepository;


    public List<Hostel> findAll() {
        return hostelRepository.findAll();
    }

    public Hostel findByName(String name) {
        return hostelRepository.findByName(name);
    }
}
