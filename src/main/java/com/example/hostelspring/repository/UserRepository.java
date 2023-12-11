package com.example.hostelspring.repository;


import com.example.hostelspring.dto.UserDto;
import com.example.hostelspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDto getUserByUsername(String login);

    UserDto addUser(String login, String password);

    void updateUser(int userId, UserDto user);
}
