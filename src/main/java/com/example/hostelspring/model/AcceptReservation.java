package com.example.hostelspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptReservation {

    @Id
    @GeneratedValue
    private int id;
    private int user_id;
    private int hostel_id;
    private String type;
    private int room_number;
    private String hostel_name;
    private String application_type;

}
