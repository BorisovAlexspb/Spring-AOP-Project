package com.example.demo.service.jpa;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;

import java.util.List;

public class JpaUserService implements UserService {
    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
