package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTests {

    @Test
    public void testFindAll() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        List<User> usersList = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(usersList);

        UserService userService = new UserService(userRepository);
        List<User> result = userService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveUser() {
        User newUser = new User();
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        when(userRepository.save(newUser)).thenReturn(newUser);

        UserService userService = new UserService(userRepository);
        User result = userService.saveUser(newUser);

        assertEquals(newUser, result);
    }

    @Test
    public void testDeleteById() {
        int userId = 1;
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        UserService userService = new UserService(userRepository);
        userService.deleteById(userId);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId);
    }
}