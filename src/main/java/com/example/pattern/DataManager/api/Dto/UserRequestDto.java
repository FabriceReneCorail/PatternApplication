package com.example.pattern.DataManager.api.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private int age;
}
