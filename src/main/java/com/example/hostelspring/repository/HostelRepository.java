package com.example.hostelspring.repository;


import com.example.hostelspring.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostelRepository extends JpaRepository<Hostel, Long> {

    Hostel findById(int id);

    List<Hostel> findAll();

    Hostel findByName(String hostel_name);
}
