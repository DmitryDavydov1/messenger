package com.example.simplemessenger.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор пользователя

    private String username; // Имя пользователя
    private String email;    // Адрес электронной почты

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Дата и время регистрации

    // Конструктор без параметров (необходим для JPA)
    public User() {}

    // Конструктор для создания нового пользователя
    public User(String username, String email, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // toString(), equals() и hashCode() можно генерировать автоматически через IDE (например, IntelliJ IDEA)
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', email='" + email + "', createdAt=" + createdAt + '}';
    }
}
