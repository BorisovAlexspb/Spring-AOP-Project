package com.example.demo.service.jpa;

import com.example.demo.model.User;
import com.example.demo.repository.JpaUserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaUserService implements UserService {

    private final JpaUserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userInfo) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setName(userInfo.getName());
            user.setEmail(userInfo.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
