package com.example.blogapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.models.User;
import com.example.blogapp.repositories.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElse(null);     }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(int userId, User userDetails) {
        User user = getUserById(userId);
        // Potential NullPointerException if user is null
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
