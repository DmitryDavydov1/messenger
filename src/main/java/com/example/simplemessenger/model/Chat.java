package com.example.simplemessenger.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор чата

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Дата и время создания чата

    // Конструктор без параметров
    public Chat() {}

    // Конструктор для создания нового чата
    public Chat(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Chat{id=" + id + ", createdAt=" + createdAt + '}';
    }
}
