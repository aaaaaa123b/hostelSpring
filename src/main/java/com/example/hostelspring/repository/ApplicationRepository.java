package com.example.hostelspring.repository;


import com.example.hostelspring.dto.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ReservationDto, Long> {
    ReservationDto findById(int id);

    ReservationDto addReservation(int user_id, int hostel_id, String type, int numberOfSeats,String hostel_name,String applicationType) ;

    void deleteById(Long id);


    List<ReservationDto> findAll();
}
