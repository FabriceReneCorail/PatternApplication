package com.example.pattern.DataManager.api.controller;

import com.example.pattern.DataManager.api.Dto.EmployeeDto;
import com.example.pattern.DataManager.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    // better to use constructor than Autowired
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @Operation(operationId = "createEmployee", description = "add a new employee and control if user already exist if not create a user linked to that employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added"),
            @ApiResponse(responseCode = "404", description = "Failed to add a new employee")})
    @PostMapping("/addEmployee")
    public ResponseEntity createEmployeeAndUserIfDoesntExist(@RequestBody EmployeeDto dto){
        service.createEmployee(dto);
        return (ResponseEntity) ResponseEntity.ok();
    }
}
