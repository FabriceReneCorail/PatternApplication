package com.example.pattern.api.controller;

import com.example.pattern.api.Dto.EmployeeDto;
import com.example.pattern.persistence.repository.EmployeeRepository;
import com.example.pattern.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    // better to use constructor than Autowired
    private final EmployeeRepository repository;

    private final EmployeeService service;

    public EmployeeController(EmployeeRepository repository, EmployeeService service) {
        this.repository = repository;
        this.service = service;
    }
    @PostMapping("/addEmployee")
    public ResponseEntity createEmployeeAndUserIfDoesntExist(@PathVariable EmployeeDto dto){
        service.createEmployee(dto);
        return (ResponseEntity) ResponseEntity.ok();
    }
}
