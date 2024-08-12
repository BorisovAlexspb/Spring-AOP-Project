package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.JpaUserRepository;
import com.example.demo.service.jpa.JpaOrderService;
import com.example.demo.service.jpa.JpaUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Mock
    private JpaUserRepository userRepository;

    @InjectMocks
    private JpaUserService userService;

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userService.getUserById(userId);
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        Long userId = 1L;
        user.setId(userId);
        user.setName("John");

        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertEquals("John", user.getName());
        User newUser = new User();
        newUser.setEmail("yandex");
        newUser.setName("Bob");
        User result = userService.updateUser(userId, newUser);
        assertNotNull(result);
        assertEquals("Bob", result.getName());
        assertEquals("yandex", result.getEmail());

    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindAllUsers() {
        User user = new User();
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        assertEquals(1, userService.getAllUsers().size());
    }
}
