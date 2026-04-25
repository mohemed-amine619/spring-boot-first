package com.spring_boot.learn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor

public class Employee {
    private UUID id;
    private String  first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private LocalDate hire_date;
    private String position;
    private UUID departementID;
}
