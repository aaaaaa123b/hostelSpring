package com.example.hostelspring.controller;


import com.example.hostelspring.dto.ReservationDto;
import com.example.hostelspring.enumerations.Role;
import com.example.hostelspring.repository.ApplicationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public AdminController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/admin")
    public String adminPage(HttpSession session, Model model) {
        Role adminRoles = (Role) session.getAttribute("roles");

        if (adminRoles != null && adminRoles.equals(Role.ADMIN)) {
            List<ReservationDto> reservationList = applicationRepository.findAll();
            model.addAttribute("reservations", reservationList);
            return "admin_applications";
        } else {
            return "error";
        }
    }
}
