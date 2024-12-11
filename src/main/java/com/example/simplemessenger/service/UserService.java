package com.example.simplemessenger.service;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String username, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("User with this email already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public User getUserByEmail(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean logIn(String username, String email) {
        return userRepository.existsByEmailAndUsername(email, username);
    }
}
