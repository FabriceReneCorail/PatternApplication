package com.example.pattern.DataManager.service.ServiceImp;

import com.example.pattern.DataManager.persistence.entity.Companies;
import com.example.pattern.DataManager.persistence.entity.Employee;
import com.example.pattern.DataManager.persistence.entity.User;
import com.example.pattern.DataManager.persistence.repository.UserRepository;
import com.example.pattern.DataManager.service.Filters.Filter;
import com.example.pattern.DataManager.service.FiltersService;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

@Service
@Hidden

public class FilterServiceImpl implements FiltersService {

    private EntityManager entityManager;
    final UserRepository userRepository;
    public FilterServiceImpl(final EntityManager entityManager, final UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }
    @Override
    public List<User> filteringByUser(final Filter filter) {
        final var users = userRepository.findAll();
        if(filter.getAge() != null){
        return users.stream().filter(e-> e.getAge() > filter.getAge()).collect(Collectors.toList());
        }
        if(filter.getSalary() != null){ // entity manager to navigate into the table and get the salary
            entityManager.getCriteriaBuilder();
        }
        return null;
    }
    @Override
    public List<Employee> filteringByEmployee(final Filter filter) {
        return null;
    }
    @Override
    public List<Companies> filteringByCompany(final Filter filter) {
        return null;
    }
}
