package com.example.hostelspring.controller;


import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.enumerations.Role;
import com.example.hostelspring.model.User;
import com.example.hostelspring.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String showAdminUsersPage(HttpSession session, Model model) {
        Role adminRoles = (Role) session.getAttribute("roles");

        if (adminRoles != null && adminRoles.equals(Role.ADMIN)) {
            List<User> users = userService.findAll();
            model.addAttribute("users", users);

            return "admin_users_page";
        } else {
            return "error";
        }
    }

    @PostMapping("/users")
    public String updateUserDetails(@RequestParam("userId") int userId,
                                    @RequestParam("block") boolean block,
                                    @RequestParam("sale") double sale,
                                    HttpSession session, Model model) {

        Role adminRoles = (Role) session.getAttribute("roles");

        if (adminRoles != null && adminRoles.equals(Role.ADMIN)) {
            UserDto userDto = userService.findUserById(userId);

            userDto.setBlock(block);
            userDto.setSale(sale);

            userService.updateUser(userId, userDto);

            List<User> users = userService.findAll();
            model.addAttribute("users", users);

            return "admin_users_page";
        } else {
            return "error";
        }
    }
}
