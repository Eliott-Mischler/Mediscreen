package com.demo.mediscreenwebapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String birthdate;
    private String phone;
    private String address;
    private Double diabetesScore;

}
