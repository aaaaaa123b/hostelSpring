package com.example.hostelspring.service.impl;

import com.example.hostelspring.dto.ReservationDto;
import com.example.hostelspring.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl {
    private final ApplicationRepository applicationRepository;

    public List<ReservationDto> findAll() {
        return applicationRepository.findAll();
    }

    public ReservationDto addReservation(int userId, int hostelId, String reservationType, int roomNumber, String hostelName, String type) {

        return applicationRepository.addReservation(userId,hostelId,reservationType,roomNumber,hostelName,type);
    }

    public void deleteById(long reservationId) {
        applicationRepository.deleteById(reservationId);
    }

    public ReservationDto findById(int reservationId) {
        return applicationRepository.findById(reservationId);
    }
}
