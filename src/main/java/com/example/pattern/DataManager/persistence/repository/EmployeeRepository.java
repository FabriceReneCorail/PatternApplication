package com.example.pattern.DataManager.persistence.repository;

import com.example.pattern.DataManager.persistence.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    List<Employee> findAll();
    @Override
    Employee getById(Long aLong);
}
