package com.example.pattern.api.controller;

import com.example.pattern.api.Dto.EmployeeDto;
import com.example.pattern.persistence.repository.EmployeeRepository;
import com.example.pattern.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeController {
    // better to use constructor than Autowired
    private final EmployeeRepository repository;

    private final EmployeeService service;

    public EmployeeController(EmployeeRepository repository, EmployeeService service) {
        this.repository = repository;
        this.service = service;
    }
    //@Operation(operationId = "createEmployee", description = "")
    @PostMapping("/addEmployee")
    public ResponseEntity createEmployeeAndUserIfDoesntExist(@RequestBody EmployeeDto dto){
        service.createEmployee(dto);
        return (ResponseEntity) ResponseEntity.ok();
    }
}
