package com.example.pattern.service;

import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.Filter;
import java.util.List;


public interface UserService {

    User getUserDtoById(final Long id);
    User getUserFromLastName(final String lastName);
    List<User> getListOfUsers(final Filter filter);
}
