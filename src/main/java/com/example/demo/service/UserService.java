package com.example.demo.service;

import com.example.demo.dto.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
