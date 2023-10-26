package com.example.pattern.persistence.repository;

import com.example.pattern.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
