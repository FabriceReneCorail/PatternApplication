package com.example.pattern.DataManager.service;

import com.example.pattern.DataManager.api.Dto.UserRequestDto;
import com.example.pattern.DataManager.api.Dto.UserResponseDto;
import com.example.pattern.DataManager.service.Filters.Filter;
import com.example.pattern.DataManager.persistence.entity.User;
import java.util.List;

public interface UserService {
    User getUserDtoById(final Long id);
    UserRequestDto getUserById(User user);
    User getUserFromLastName(final String lastName);
    List<User> getListOfUsers(final Filter filter);
    void addNewUser(final UserRequestDto user);
    UserResponseDto getUserInfosByLastName(final User lastName);

    List<UserRequestDto> getUsers();

    void updateUser(UserRequestDto newUser);
}
