package com.example.hostelspring.service;

import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.model.User;

import java.util.List;

public interface UserService {
    int calculateOrderNumber(int userId);

    UserDto getUserByUsername(String login);

    UserDto addUser(String login, String password);

    UserDto findUserById(int userId);

    void updateUser(int userId, UserDto user);

    List<User> findAll();
}
