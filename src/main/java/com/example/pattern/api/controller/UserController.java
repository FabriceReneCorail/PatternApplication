package com.example.pattern.api.controller;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.Filter;
import com.example.pattern.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestDto> getUserById(@PathVariable Long id) {
        User user = userService.getUserDtoById(id);
        UserRequestDto userResponseDto = userService.getUserById(user);
        return ResponseEntity.ok(userResponseDto);
    }
    @GetMapping("/{lastName}")
    public ResponseEntity<User> getUserByLastName(@PathVariable String lastName) {
        User user = userService.getUserFromLastName(lastName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{filter}")
    public ResponseEntity<UserRequestDto> getListOfUsers(@PathVariable Filter filter) {
        //filter are supposed to be used with the front end part and triggered by an Angular event . all the datas are in the back and it will just filter them
        List<User> userEntities = userService.getListOfUsers(filter);
        return ResponseEntity.ok((UserRequestDto) userEntities);
    }
    @PostMapping("/addUser")
    public ResponseEntity newUser(@PathVariable UserRequestDto newUser) {
        userService.addNewUser(newUser);
        return (ResponseEntity) ResponseEntity.ok();
    }

}
