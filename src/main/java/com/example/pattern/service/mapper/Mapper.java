package com.example.pattern.service.mapper;

import com.example.pattern.api.Dto.EmployeeDto;
import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.api.Dto.UserResponseDto;
import com.example.pattern.persistence.entity.Companies;
import com.example.pattern.persistence.entity.Employee;
import com.example.pattern.persistence.entity.Jobs;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserRequestDto mapEntityToDto(final User entity) {
        UserRequestDto dto = new UserRequestDto();
        dto.setAge(entity.getAge());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        return dto;
    }
    public User mapDtoToEntity(final UserRequestDto dto) {
        User userEntity = new User();
        userEntity.setAge(dto.getAge());
        userEntity.setName(dto.getName());
        userEntity.setLastname(dto.getLastname());
        return userEntity;
    }

    public static Employee employeeMapper(final EmployeeDto employeeDto) {
        final var employeeEntity = new Employee();
        employeeEntity.setEmployeeName(employeeDto.getName());
        employeeEntity.setMatricule(employeeEntity.getMatricule());
        employeeEntity.setCompanyName(employeeEntity.getCompanyName());
        employeeEntity.setEmployeeSalary(employeeEntity.getEmployeeSalary());
        return employeeEntity;
    }

    public static UserResponseDto mapperEntitiesToResponseDto(User user , Employee employee){
        // in the signature we have to had more param like job and companies
        return null;
    };
}