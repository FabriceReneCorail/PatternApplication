package com.example.pattern.service.ServiceImp;

import com.example.pattern.api.Dto.EmployeeDto;
import com.example.pattern.persistence.entity.Employee;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.EmployeeRepository;
import com.example.pattern.persistence.repository.UserRepository;
import com.example.pattern.service.EmployeeService;
import org.springframework.stereotype.Service;

import static com.example.pattern.service.mapper.Mapper.employeeMapperDtoToEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private UserRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository repository ,UserRepository userRepository ){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void createEmployee(final EmployeeDto employeeDto) {
        // create employee
        final Employee employee = employeeMapperDtoToEntity(employeeDto);
        repository.save(employee);
        // link employee to user if it's possible
        if(!findUserCommonPoint(employee)){
            final var newUserLinkWithEmployee = new User();
            newUserLinkWithEmployee.setName(employee.getEmployeeName());
            newUserLinkWithEmployee.setLastname(employee.getEmployeeLastName());
            userRepository.save(newUserLinkWithEmployee);
        }
    }
    private Boolean findUserCommonPoint(final Employee employee) {
                return userRepository.findAll().stream()
                        .anyMatch(user -> user.getLastname()
                                .equals(employee.getEmployeeLastName()));
    }
    @Override
    public void transfertEmployeeToOtherCompany(final EmployeeDto employeeDto) {

    }
}
