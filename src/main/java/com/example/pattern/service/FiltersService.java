package com.example.pattern.service;

import com.example.pattern.persistence.entity.Companies;
import com.example.pattern.persistence.entity.Employee;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.Filter;
import java.util.List;

public interface FiltersService {
    List<User> filteringByUser(final Filter filter);
    List<Employee> filteringByEmployee(final Filter filter);
    List<Companies> filteringByCompany(final Filter filter);
}
