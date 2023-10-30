package com.example.pattern.service;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.api.Dto.UserResponseDto;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.Filter;
import java.util.List;

public interface UserService {
    User getUserDtoById(final Long id);
    UserRequestDto getUserById(User user);
    User getUserFromLastName(final String lastName);
    List<User> getListOfUsers(final Filter filter);
    void addNewUser(final UserRequestDto user);
    UserResponseDto getUserInfosByLastName(final User lastName);
}
