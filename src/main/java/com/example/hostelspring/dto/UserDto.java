package com.example.hostelspring.dto;


import com.example.hostelspring.enumerations.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int user_id;
    private String login;
    private String password;
    private double sale;
    private boolean block;
    private int order_number;
    Role roles;

}
