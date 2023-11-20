package com.example.pattern.DataManager.api.Dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String email;
}
