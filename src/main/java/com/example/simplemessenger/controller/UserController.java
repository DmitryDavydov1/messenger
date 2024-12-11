package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@OpenAPIDefinition

public class UserController {

    @Autowired
    private UserService userService;

    // Регистрация нового пользователя
    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user.getUsername(), user.getEmail());
    }

    @PostMapping("/log-int")
    public boolean logIn(@RequestBody User user) {
        return userService.logIn(user.getUsername(), user.getEmail());
    }


    // Получить всех пользователей
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//    }
//
//    // Получить пользователя по ID
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Удалить пользователя по ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<User>> findUsers(@RequestParam String username) {
//        return userService.findUser(username) != null ? new ResponseEntity<>(userService.findUser(username), HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping("already-exists")
//    public boolean findUserAlreadyExists(@RequestParam String username) {
//        boolean empty = userService.findUser(username).isEmpty();
//        return !empty;
//    }

}
