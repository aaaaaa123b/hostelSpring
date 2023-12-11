package com.example.hostelspring.controller;

import com.example.hostelspring.enumerations.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String showDashboard(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("roles");

        return moveToMenu(role);
    }

    private String moveToMenu(Role role) {
        if (role.equals(Role.ADMIN)) {
            return "admin_page";
        } else if (role.equals(Role.USER)) {
            return "redirect:/apartments";
        } else {
            return "login";
        }
    }
}

