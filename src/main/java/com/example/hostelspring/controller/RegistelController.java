package com.example.hostelspring.controller;

import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.repository.UserRepository;
import com.example.hostelspring.service.UserService;
import com.example.hostelspring.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RegistelController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/")
    public String register(UserDto user, Map<String, String> fields) {
        final String login = fields.get("login");
        final String password = fields.get("password");

         UserDto addedUser = userService.addUser(login, password);

        if (addedUser.getPassword().equals(password)) {
        return "redirect:/dashboard";
         } else {
            throw new RuntimeException("Error during registration");
         }
    }
}
