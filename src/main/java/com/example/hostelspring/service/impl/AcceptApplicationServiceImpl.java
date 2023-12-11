package com.example.hostelspring.service.impl;

import com.example.hostelspring.dto.ReservationDto;
import com.example.hostelspring.repository.AcceptApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AcceptApplicationServiceImpl {

    AcceptApplicationRepository acceptApplicationRepository;

    public List<ReservationDto> findAll() {
        return acceptApplicationRepository.findAll();
    }

    public void addReservation(String type, int roomNumber, int userId, int hostelId, String hostelName, String applicationType) {

        acceptApplicationRepository.addReservation(type,roomNumber,userId,hostelId,hostelName,applicationType);
    }

}
