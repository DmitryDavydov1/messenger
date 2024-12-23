package com.example.simplemessenger.service;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * Если id email пользователя уже есть в бд, то он возвращает его,
     * если нет, то регистрирует нового пользователя, в бд
     * Используется методы репозитория
     * <br>
     * {@link JpaRepository#save(Object)}
     * <br>
     * {@link JpaRepository#findById(Object)}
     * @param username
     * @param email уникальный email пользователя
     * @return пользователь
     */
    public User registerUser(String username, String email) {
        if (userRepository.existsByEmail(email)) {
            return userRepository.findByEmail(email).get();
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return userRepository.findById(user.getId()).get();
    }

    public User getUserByEmail(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean logIn(String username, String email) {
        return userRepository.existsByEmailAndUsername(email, username);
    }
}
