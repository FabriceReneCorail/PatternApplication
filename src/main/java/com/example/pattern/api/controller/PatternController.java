package com.example.pattern.api.controller;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.UserFilter;
import com.example.pattern.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PatternController {


    private final UserService userService;
    @Autowired
    public PatternController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User userRequestDto = userService.getUserDtoById(id);
        return ResponseEntity.ok(userRequestDto);
    }
    @GetMapping("/{lastName}")
    public ResponseEntity<User> getUserByLastName(@PathVariable String lastName){
        User user = userService.getUserFromLastName(lastName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{filter}")
    public ResponseEntity<User> getListOfUsers(@PathVariable UserFilter lastName){
        List<User> users = userService.getListOfUsers(lastName);
        return ResponseEntity.ok((User) users);
    }


}
