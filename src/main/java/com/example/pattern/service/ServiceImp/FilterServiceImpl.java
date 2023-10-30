package com.example.pattern.service.ServiceImp;

import com.example.pattern.persistence.entity.Companies;
import com.example.pattern.persistence.entity.Employee;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.UserRepository;
import com.example.pattern.service.Filters.Filter;
import com.example.pattern.service.FiltersService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FiltersService {

    final UserRepository userRepository;
    public FilterServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> filteringByUser(final Filter filter) {
        final var users = userRepository.findAll();
        if(filter.getAge() != null){
        return users.stream().filter(e-> e.getAge() > filter.getAge()).collect(Collectors.toList());
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
