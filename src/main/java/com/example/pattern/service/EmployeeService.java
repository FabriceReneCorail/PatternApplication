package com.example.pattern.service;

import com.example.pattern.api.Dto.EmployeeDto;

public interface EmployeeService {

    void createEmployee(EmployeeDto employeeDto);
    void transfertEmployeeToOtherCompany(EmployeeDto employeeDto);
}
