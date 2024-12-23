package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@OpenAPIDefinition
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "мы регистрируем  нового пользователя " +
            "или возвращаем данные старого пользователя",
            responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "мы зарегистрировали нового пользователя " +
                            "или вернули данные старого пользователя",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
//                                examples = @ExampleObject("1:2")
                            )
                    }
            ),
                    @ApiResponse(responseCode = "404",
                    description = "Если книги не найдены")
    })
    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@Parameter(description = "Все поля класса User(id, email, username, createdAd)") @RequestBody User user) {
        User users = userService.registerUser(user.getUsername(), user.getEmail());
        return ResponseEntity.ok(users);
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
