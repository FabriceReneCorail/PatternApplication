package com.example.pattern.service;

import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.UserRepository;
import com.example.pattern.service.Filters.UserFilter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository =userRepository;}

    public User getUserDtoById(Long id){
       return userRepository.findFirstById(id);
    }

    public User getUserFromLastName(String lastName) {
        return userRepository.findByLastname(lastName);
    }

    public List<User> getListOfUsers(UserFilter filter){
       final var getAllUsers= userRepository.findAll();
      return getAllUsers.stream().filter(e -> e.getAge() > filter.getAge()).collect(Collectors.toList());
    }
}
