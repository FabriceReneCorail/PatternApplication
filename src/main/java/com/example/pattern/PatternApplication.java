package com.example.pattern;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.Filter;
import com.example.pattern.service.UserService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PatternApplication {
    public static void main(String[] args) {
         SpringApplication.run(PatternApplication.class, args);
    }
}
