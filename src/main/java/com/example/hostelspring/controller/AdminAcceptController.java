package com.example.hostelspring.controller;

import com.example.hostelspring.dto.ReservationDto;
import com.example.hostelspring.enumerations.Role;
import com.example.hostelspring.repository.AcceptApplicationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminAcceptController {

    private final AcceptApplicationRepository applicationRepository;

    @Autowired
    public AdminAcceptController(AcceptApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/adminList")
    public String adminAcceptPage(HttpSession session, Model model) {
        Role adminRoles = (Role) session.getAttribute("roles");

        if (adminRoles != null && adminRoles.equals(Role.ADMIN)) {
            List<ReservationDto> reservationList = applicationRepository.findAll();
            model.addAttribute("accept_applications", reservationList);
            return "admin_accept_applications";
        } else {
            return "error";
        }
    }
}
