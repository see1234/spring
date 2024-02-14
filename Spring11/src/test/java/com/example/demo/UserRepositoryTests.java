package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class UserRepositoryTests {



    @Test
    public void testSave() {
        User user = new User();
        JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        UserRepository userRepository = new UserRepository(jdbcTemplate);

        when(jdbcTemplate.update(Mockito.anyString(), any(), any())).thenReturn(1);

        User result = userRepository.save(user);

        assertEquals(user, result);
    }

    @Test
    public void testDeleteById() {
        int userId = 1;
        JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        UserRepository userRepository = new UserRepository(jdbcTemplate);

        userRepository.deleteById(userId);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(), Mockito.eq(userId));
    }
}