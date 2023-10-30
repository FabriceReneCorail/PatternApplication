package com.example.pattern.api.Dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String lastname;
    private String company;
    private String fonction;
    private Long matricule;
}
