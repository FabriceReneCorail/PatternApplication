package com.example.pattern.DataManager.service;

import com.example.pattern.DataManager.persistence.entity.Companies;
import com.example.pattern.DataManager.persistence.entity.Employee;
import com.example.pattern.DataManager.persistence.entity.User;
import com.example.pattern.DataManager.service.Filters.Filter;
import java.util.List;

public interface FiltersService {
    List<User> filteringByUser(final Filter filter);
    List<Employee> filteringByEmployee(final Filter filter);
    List<Companies> filteringByCompany(final Filter filter);
}
