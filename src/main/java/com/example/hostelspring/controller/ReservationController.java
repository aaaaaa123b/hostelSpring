package com.example.hostelspring.controller;

import com.example.hostelspring.model.Apartment;
import com.example.hostelspring.service.impl.ApartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ApartmentServiceImpl apartmentService;

    @GetMapping("/reservationServlet")
    public String showBookPage(@RequestParam(name = "action", required = false) String action,
                               @RequestParam(name = "apartmentId", required = false) String apartmentId,
                               Model model) {
        if (action != null && apartmentId != null) {
            int apartmentIdInt = Integer.parseInt(apartmentId);
            Apartment apartment = apartmentService.findById(apartmentIdInt);
            model.addAttribute("apartment", apartment);
        }

        return "book_page";
    }

    @PostMapping("/reservationServlet")
    public String handleReservationAction(@RequestParam(name = "action") String action,
                                          @RequestParam(name = "apartmentId", required = false) String apartmentId,
                                          Model model) {
        if ("Accept".equals(action) && apartmentId != null) {
            int apartmentIdInt = Integer.parseInt(apartmentId);
            Apartment apartment = apartmentService.findById(apartmentIdInt);
            model.addAttribute("apartment", apartment);
        }

        return "book_page";
    }
}

