package com.example.pattern.persistence.repository;

import com.example.pattern.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLastname(String lastname);
    User findFirstById(Long id);
}
