package com.example.simplemessenger.model;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.User;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор записи

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Пользователь

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat; // Чат

    @Column(name = "joined_at")
    private LocalDateTime joinedAt; // Дата и время присоединения пользователя к чату

    // Конструктор без параметров
    public UserChat() {}

    // Конструктор для создания записи
    public UserChat(User user, Chat chat, LocalDateTime joinedAt) {
        this.user = user;
        this.chat = chat;
        this.joinedAt = joinedAt;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "UserChat{id=" + id + ", user=" + user + ", chat=" + chat + ", joinedAt=" + joinedAt + '}';
    }
}
