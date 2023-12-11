package com.example.hostelspring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("password");
        session.removeAttribute("login");
        session.removeAttribute("role");

        return "redirect:/register";
    }
}
