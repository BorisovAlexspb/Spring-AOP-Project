package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long userId, User userInfo);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
