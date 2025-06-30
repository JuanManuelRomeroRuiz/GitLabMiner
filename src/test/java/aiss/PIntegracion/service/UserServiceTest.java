package aiss.PIntegracion.service;

import aiss.PIntegracion.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Get all users")
    void getUsers() {
        List<User> users = userService.getAllUsers();
        assertFalse(users.isEmpty());
        System.out.println(users);
    }

    @Test
    @DisplayName("Get user by ID")
    void getUserById() {
        User user = userService.getUserById(1);
        assertNotNull(user);
        System.out.println(user);
    }
}