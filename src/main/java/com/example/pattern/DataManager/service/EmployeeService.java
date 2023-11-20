package com.example.pattern.DataManager.service;

import com.example.pattern.DataManager.api.Dto.EmployeeDto;
import com.example.pattern.DataManager.api.Dto.InformationDto;

public interface EmployeeService {

    void createEmployee(EmployeeDto employeeDto);
    void transfertEmployeeToOtherCompany(EmployeeDto employeeDto, InformationDto comment);
    void handleEmployeeSalary(EmployeeDto dto);
}
