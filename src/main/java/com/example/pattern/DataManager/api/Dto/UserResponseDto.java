package com.example.pattern.DataManager.api.Dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private UserRequestDto user;
    private EmployeeDto userInfosAsEmployee;
}
