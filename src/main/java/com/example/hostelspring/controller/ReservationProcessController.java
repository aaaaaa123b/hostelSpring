package com.example.hostelspring.controller;


import com.example.hostelspring.dto.ReservationDto;
import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.enumerations.Role;
import com.example.hostelspring.service.UserService;
import com.example.hostelspring.service.impl.AcceptApplicationServiceImpl;
import com.example.hostelspring.service.impl.ApplicationServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReservationProcessController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationProcessController.class);

    private final ApplicationServiceImpl applicationService;
    private final AcceptApplicationServiceImpl acceptApplicationService;
    private final UserService userService;

    @GetMapping("/processReservation")
    public String processReservation(@RequestParam(name = "action") String action,
                                     @RequestParam(name = "reservationId") int reservationId,
                                     HttpSession session) {

        Role adminRoles = (Role) session.getAttribute("roles");

        if (adminRoles != null && adminRoles.equals(Role.ADMIN)) {
            if ("Accept".equals(action)) {
                acceptReservation(reservationId);
            } else if ("Reject".equals(action)) {
                rejectReservation(reservationId);
            }

            return "redirect:/admin";
        } else {
            return "error";
        }
    }

    private void acceptReservation(int reservationId) {
        ReservationDto reservation = applicationService.findById(reservationId);
        acceptApplicationService.addReservation(reservation.getType(), reservation.getRoom_number(), reservation.getUser_id(), reservation.getHostel_id(), reservation.getHostel_name(), reservation.getApplication_type());
        applicationService.deleteById((long) reservationId);

        int userId = reservation.getUser_id();
        int count = userService.calculateOrderNumber(userId);
        UserDto user = userService.findUserById(userId);
        user.setOrder_number(count);
        userService.updateUser(userId, user);

        logger.info("Reservation accepted: " + reservationId);
    }

    private void rejectReservation(long reservationId) {
        applicationService.deleteById(reservationId);

        logger.info("Reservation rejected: " + reservationId);
    }
}

