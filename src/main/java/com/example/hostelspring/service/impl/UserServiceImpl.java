package com.example.hostelspring.service.impl;


import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.model.User;
import com.example.hostelspring.repository.UserRepository;
import com.example.hostelspring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;


    @Override
    public int calculateOrderNumber(int userId) {
        return 0;
    }

    @Override
    public UserDto getUserByUsername(String login) {
        return userRepository.getUserByUsername(login);
    }

    @Override
    public UserDto addUser(String login, String password) {
        return userRepository.addUser(login,password);
    }

    @Override
    public UserDto findUserById(int userId) {
        return null;
    }

    @Override
    public void updateUser(int userId, UserDto user) {
        userRepository.updateUser(userId,user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }



}


