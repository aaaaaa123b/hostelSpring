package com.example.hostelspring.controller;

import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.model.Hostel;
import com.example.hostelspring.service.UserService;
import com.example.hostelspring.service.impl.ApartmentServiceImpl;
import com.example.hostelspring.service.impl.ApplicationServiceImpl;
import com.example.hostelspring.service.impl.HostelServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class HostelReservationController {

    private final HostelServiceImpl hostelService;
    private final ApplicationServiceImpl applicationService;
    private final UserService userService;
    private final ApartmentServiceImpl apartmentService;

    @GetMapping("/hostelReservation")
    public ModelAndView showReservationForm(@RequestParam("action") String action,
                                            @RequestParam("reservationType") String reservationType,
                                            @RequestParam("type") String type,
                                            @RequestParam("apartment_number") int roomNumber,
                                            @RequestParam("apartment_id") int roomId,
                                            HttpSession session) {

        String login = (String) session.getAttribute("login");
        UserDto user = userService.getUserByUsername(login);

        String hostelName = apartmentService.findById(roomId).getHostel_name();
        Hostel hostel = hostelService.findByName(hostelName);

        if ("reserve".equals(action)) {
            applicationService.addReservation(user.getUser_id(), hostel.getId(), reservationType, roomNumber, hostelName, type);
            return new ModelAndView("redirect:/apartments");
        } else {
            return new ModelAndView("error");
        }
    }
}