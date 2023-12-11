package com.example.hostelspring.controller;

import com.example.hostelspring.enumerations.Role;
import com.example.hostelspring.model.Apartment;
import com.example.hostelspring.repository.ApartmentRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HostelController {

    private final ApartmentRepository apartmentRepository;

    @GetMapping("/apartments")
    public String showApartments(HttpSession session, Model model) {
        Role userRole = (Role) session.getAttribute("roles");

        if (userRole != null && userRole.equals(Role.USER)) {
            List<Apartment> apartmentList = apartmentRepository.findAll();
            model.addAttribute("hostelList", apartmentList);
            return "user_page";
        } else {
            return "error";
        }
    }
}
