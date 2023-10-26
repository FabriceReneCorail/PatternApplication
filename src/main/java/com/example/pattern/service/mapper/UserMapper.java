package com.example.pattern.service.mapper;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.persistence.entity.User;

public class UserMapper {

    private UserRequestDto mapEntityToDto(User entity) {
        UserRequestDto dto = new UserRequestDto();
        dto.setAge(entity.getAge());
        dto.setId(entity.getId());
        dto.setLastname(entity.getLastname());
        dto.setLastname(entity.getLastname());
        return dto;
    }
}