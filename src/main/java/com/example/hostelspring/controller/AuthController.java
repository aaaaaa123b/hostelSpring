package com.example.hostelspring.controller;


import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.repository.UserRepository;
import com.example.hostelspring.service.UserService;
import com.example.hostelspring.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView( "login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserDto user, Model model) {
       UserDto existingUser = userService.getUserByUsername(user.getLogin());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("roles", existingUser.getRoles());
            model.addAttribute("login", existingUser.getLogin());
            return new ModelAndView( "login");
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }
}


