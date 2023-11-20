package com.example.pattern;

import com.example.pattern.DataManager.persistence.entity.User;
import com.example.pattern.DataManager.service.ServiceImp.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class DataManagerTests {

    private UserServiceImpl service;

    public DataManagerTests(UserServiceImpl service) {
        this.service = service;
    }

    @Test
    public void shouldReturnAUser(String lastName){
        User user1 = new User();
        user1.setLastname("andress");
        user1.setId(25333654L);
        user1.setAge(25);
        user1.setName("fabio");
        user1.setId(2L);
        assertEquals(user1, service.getUserFromLastName("andress"));
// commencer par un test qui fail sans méthode impléménté
    }


}
