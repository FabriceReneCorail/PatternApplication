package com.example.pattern.api.Dto;

import com.example.pattern.persistence.entity.Jobs;
import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String lastname;
    private String company;
    private String fonction;
    private Long matricule;
    private Long salary;
}
