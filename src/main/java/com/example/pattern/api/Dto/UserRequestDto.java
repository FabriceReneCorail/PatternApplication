package com.example.pattern.api.Dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String name;
    private String lastname;
    private int age;
}
