package com.example.pattern.DataManager.api.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    private String company;
    private String fonction;
    private Long matricule;
    @NotNull
    private Long salary;
}
