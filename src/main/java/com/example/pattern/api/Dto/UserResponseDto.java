package com.example.pattern.api.Dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private UserRequestDto user;
    private EmployeeDto userInfosAsEmployee;
}
