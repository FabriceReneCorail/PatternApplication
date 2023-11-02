package com.example.pattern.DataManager.persistence.repository;

import com.example.pattern.DataManager.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLastname(String lastname);
    User findFirstById(Long id);
}
