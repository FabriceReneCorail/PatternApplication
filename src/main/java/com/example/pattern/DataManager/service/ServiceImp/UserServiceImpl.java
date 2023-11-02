package com.example.pattern.DataManager.service.ServiceImp;

import com.example.pattern.DataManager.api.Dto.UserRequestDto;
import com.example.pattern.DataManager.api.Dto.UserResponseDto;
import com.example.pattern.DataManager.service.Filters.Filter;
import com.example.pattern.DataManager.persistence.entity.User;
import com.example.pattern.DataManager.persistence.repository.EmployeeRepository;
import com.example.pattern.DataManager.persistence.repository.UserRepository;
import com.example.pattern.DataManager.service.FiltersService;
import com.example.pattern.DataManager.service.UserService;
import com.example.pattern.DataManager.service.mapper.Mapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.pattern.DataManager.service.mapper.Mapper.mappingEntitiesToResponseDto;

@Service
public class UserServiceImpl implements UserService {
    private final EmployeeRepository employeeRepository;
    private UserRepository userRepository;
    private Mapper mapper;
    private FiltersService filtersService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, FiltersService filtersService, Mapper mapper, EmployeeRepository employeeRepository){
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.filtersService = filtersService;
        this.mapper = mapper;
    }

    public User getUserDtoById(final Long id){
        return userRepository.findFirstById(id);
    }

    public UserRequestDto getUserById(User user){
        return mapper.mapEntityToDto(user);
    }

    public User getUserFromLastName(final String lastName) {
        return userRepository.findByLastname(lastName);
    }

    public List<User> getListOfUsers(final Filter filter){
        return filtersService.filteringByUser(filter);
    }
    public void addNewUser(final UserRequestDto user) {
        final var result = mapper.mapDtoToEntity(user);
        userRepository.save(result);
    }
    public UserResponseDto getUserInfosByLastName(final User lastName) {
        final var user = userRepository.findByLastname(lastName.getLastname());
        final var getEmployee = employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getEmployeeLastName().equals(user.getLastname()))
                .filter(employee -> employee.getEmployeeName().equals(user.getName()))
                .findFirst().orElse(null);
       return mappingEntitiesToResponseDto(mapper.mapEntityToDto(user),mapper.employeeMapperEntityToDto(getEmployee));
    }
}
