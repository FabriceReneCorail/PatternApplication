package com.example.pattern;

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

        ApplicationContext context = SpringApplication.run(PatternApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        Long userId = 1L; // Exemple d'ID d'utilisateur
        User user = userService.getUserDtoById(userId);
        System.out.println("Utilisateur récupéré : " + user);
        User user1 = userService.getUserFromLastName("Johnson");
        System.out.println("Utilisateur récupéré : " + user1);
        Filter filter = new Filter();
        filter.setAge(30);
        List<User> userEntities = userService.getListOfUsers(filter);
        System.out.println("liste d'utilisateurs don't l'age est superieur à " + filter.getAge() +"ans"+": "+ userEntities);
    }
}
