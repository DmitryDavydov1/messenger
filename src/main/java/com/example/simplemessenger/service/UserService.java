package com.example.simplemessenger.service;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Регистрация нового пользователя
    public User registerUser(User user) {
        return userRepository.save(user);  // Сохраняет нового пользователя в базе данных
    }

    // Получить всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);  // Возвращает пользователя по ID или null, если не найден
    }

    // Удалить пользователя
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findUser(String username) {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getUsername().contains(username)) {
                users.add(user);
            }
        }
        return users;
    }
}