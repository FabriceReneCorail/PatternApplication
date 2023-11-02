package com.example.pattern.DataManager.service.mapper;

import com.example.pattern.DataManager.api.Dto.UserRequestDto;
import com.example.pattern.DataManager.api.Dto.UserResponseDto;
import com.example.pattern.DataManager.persistence.entity.Employee;
import com.example.pattern.DataManager.api.Dto.EmployeeDto;
import com.example.pattern.DataManager.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static UserRequestDto mapEntityToDto(final User entity) {
        UserRequestDto dto = new UserRequestDto();
        dto.setAge(entity.getAge());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastname());
        return dto;
    }
    public static User mapDtoToEntity(final UserRequestDto dto) {
        User userEntity = new User();
        userEntity.setAge(dto.getAge());
        userEntity.setName(dto.getName());
        userEntity.setLastname(dto.getLastName());
        return userEntity;
    }

    public static Employee employeeMapperDtoToEntity(final EmployeeDto employeeDto) {
        final var employeeEntity = new Employee();
        employeeEntity.setEmployeeName(employeeDto.getName());
        employeeEntity.setMatricule(employeeEntity.getMatricule());
        employeeEntity.setCompanyName(employeeEntity.getCompanyName());
        employeeEntity.setEmployeeSalary(employeeEntity.getEmployeeSalary());
        return employeeEntity;
    }

    public static EmployeeDto employeeMapperEntityToDto(final Employee employee) {
        final var employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getEmployeeName());
        employeeDto.setLastname(employee.getEmployeeLastName());
        employeeDto.setMatricule(employee.getMatricule());
        employeeDto.setCompany(employee.getCompanyName());
        employeeDto.setSalary(employee.getEmployeeSalary());
        employeeDto.setFonction(employee.getFonction());
        return employeeDto;
    }

    public static UserResponseDto mappingEntitiesToResponseDto(final UserRequestDto user , final EmployeeDto employee){
        // in the signature we have to had more params like job and companies
        final var response = new UserResponseDto();
        response.setUser(user);
        response.setUserInfosAsEmployee(employee);
        return response;
    };
}