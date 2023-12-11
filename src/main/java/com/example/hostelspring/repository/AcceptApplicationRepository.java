package com.example.hostelspring.repository;


import com.example.hostelspring.dto.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptApplicationRepository extends JpaRepository<ReservationDto, Long> {

    void addReservation(String type, int room_number, int user_id, int hostel_id, String hostel_name, String applicationType);

    List<ReservationDto> findByUser_id(int user_id);

}
