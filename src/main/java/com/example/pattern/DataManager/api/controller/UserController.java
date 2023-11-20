package com.example.pattern.DataManager.api.controller;

import com.example.pattern.DataManager.api.Dto.UserRequestDto;
import com.example.pattern.DataManager.api.Dto.UserResponseDto;
import com.example.pattern.DataManager.service.Filters.Filter;
import com.example.pattern.DataManager.service.UserService;
import com.example.pattern.DataManager.persistence.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/User/getUserById/{id}")
    public ResponseEntity<UserRequestDto> getUserById(@PathVariable Long id) {
        User user = userService.getUserDtoById(id);
        UserRequestDto userResponseDto = userService.getUserById(user);
        return ResponseEntity.ok(userResponseDto);
    }
    @GetMapping("User/getUserByLastName/{lastName}")
    public ResponseEntity<UserResponseDto> getUserByLastName(@PathVariable String lastName) {
        User user = userService.getUserFromLastName(lastName);
        //agreggate infos user, employee, etc
        UserResponseDto userResponseDto = userService.getUserInfosByLastName(user);
        return ResponseEntity.ok(userResponseDto);
    }
    @GetMapping("/User/getListOfUsers/{filter}")
    public ResponseEntity<UserRequestDto> getListOfUsers(@PathVariable Filter filter) {
        //filter are supposed to be used with the front end part and triggered by an Angular event . all the datas are in the back and it will just filter them
        List<User> userEntities = userService.getListOfUsers(filter);
        return ResponseEntity.ok((UserRequestDto) userEntities);
    }
    @GetMapping("Users")
    public ResponseEntity<List<UserRequestDto>> getAllUser(){
        List<UserRequestDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/User/addUser")
    public ResponseEntity<Void> newUser(@RequestBody UserRequestDto newUser) {
        userService.addNewUser(newUser);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/User/updateUser")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDto newUser) {
        userService.updateUser(newUser);
        return ResponseEntity.ok().build();
    }


}
