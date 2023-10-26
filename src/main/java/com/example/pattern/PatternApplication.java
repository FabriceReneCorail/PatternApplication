package com.example.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.service.Filters.UserFilter;
import com.example.pattern.service.UserService;
import java.util.List;

@SpringBootApplication
public class PatternApplication {

    public static void main(String[] args) {

        // Récupérer le contexte Spring
        ApplicationContext context = SpringApplication.run(PatternApplication.class, args);

        // Récupérer le UserService à partir du contexte
        UserService userService = context.getBean(UserService.class);

        // Utiliser le UserService pour récupérer des données depuis la base de données
        Long userId = 1L; // Exemple d'ID d'utilisateur
        User user = userService.getUserDtoById(userId);
        System.out.println("Utilisateur récupéré : " + user);

        User user1 = userService.getUserFromLastName("Johnson");
        System.out.println("Utilisateur récupéré : " + user1);

        UserFilter filter = new UserFilter();
        filter.setAge(30);
        List<User> userEntities = userService.getListOfUsers(filter);
        System.out.println("liste d'utilisateurs don't l'age est superieur à " + filter.getAge() +"ans"+": "+ userEntities);
    }
}
