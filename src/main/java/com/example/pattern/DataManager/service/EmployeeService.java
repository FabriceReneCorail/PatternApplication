package com.example.pattern.DataManager.service;

import com.example.pattern.DataManager.api.Dto.EmployeeDto;

public interface EmployeeService {

    void createEmployee(EmployeeDto employeeDto);
    EmployeeDto transfertEmployeeToOtherCompany(EmployeeDto employeeDto);
}
