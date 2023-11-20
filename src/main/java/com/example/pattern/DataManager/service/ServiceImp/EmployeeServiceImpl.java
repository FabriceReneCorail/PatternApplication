package com.example.pattern.DataManager.service.ServiceImp;

import com.example.pattern.DataManager.api.Dto.EmployeeDto;
import com.example.pattern.DataManager.persistence.entity.Employee;
import com.example.pattern.DataManager.persistence.entity.User;
import com.example.pattern.DataManager.persistence.repository.EmployeeRepository;
import com.example.pattern.DataManager.persistence.repository.UserRepository;
import com.example.pattern.DataManager.service.EmployeeService;
import com.example.pattern.DataManager.service.mapper.Mapper;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Hidden

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private UserRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository repository ,UserRepository userRepository ){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void createEmployee(final EmployeeDto employeeDto) {
        // create employee
        final Employee employee = Mapper.employeeMapperDtoToEntity(employeeDto);
        repository.save(employee);
        // link employee to user if it's possible
        if(!findUserCommonPoint(employee)){
            final var newUserLinkWithEmployee = new User();
            newUserLinkWithEmployee.setName(employee.getEmployeeName());
            newUserLinkWithEmployee.setLastname(employee.getEmployeeLastName());
            userRepository.save(newUserLinkWithEmployee);
            // create a reminder when the user will use keycloak to connect on App maybe ?
        }
    }
    private Boolean findUserCommonPoint(final Employee employee) {
                return userRepository.findAll().stream()
                        .anyMatch(user -> user.getLastname()
                                .equals(employee.getEmployeeLastName()));
    }
    @Override
    public EmployeeDto transfertEmployeeToOtherCompany(final EmployeeDto employeeDto) {
        // recuperer la liste des companies existantes?
        repository.findAll().stream().filter(employee -> Boolean.parseBoolean(employee.getCompanyName())).collect(Collectors.toList());
        //checker que la demande de changement de compagnie est valide
        //update les values sur le dto
        // envoyer les infos à l'entité puis en base
        return null;
    }
}
