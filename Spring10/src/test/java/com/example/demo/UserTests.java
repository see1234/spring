package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTests {

    @Test
    public void testEquals() {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Doe");

        User user2 = new User();
        user2.setId(1);
        user2.setFirstName("John");
        user2.setLastName("Doe");

        User user3 = new User();
        user3.setId(2);
        user3.setFirstName("Jane");
        user3.setLastName("Smith");

        assertEquals(user1, user2); // Проверяем равенство двух одинаковых пользователей
        assertNotEquals(user1, user3); // Проверяем неравенство двух разных пользователей
    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Doe");

        User user2 = new User();
        user2.setId(1);
        user2.setFirstName("John");
        user2.setLastName("Doe");

        assertEquals(user1.hashCode(), user2.hashCode()); // Хэш-коды одинаковых пользователей должны совпадать
    }
}