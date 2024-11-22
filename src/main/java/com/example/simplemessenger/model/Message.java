package com.example.simplemessenger.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор сообщения

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat; // Связь с чатом

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender; // Отправитель сообщения

    private String content; // Текст сообщения

    @Column(name = "timestamp")
    private LocalDateTime timestamp; // Время отправки

    private String status; // Статус сообщения (sent, delivered, read)

    // Конструктор без параметров
    public Message() {}

    // Конструктор для создания нового сообщения
    public Message(Chat chat, User sender, String content, LocalDateTime timestamp, String status) {
        this.chat = chat;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{id=" + id + ", chat=" + chat + ", sender=" + sender + ", content='" + content + "', timestamp=" + timestamp + ", status='" + status + "'}";
    }
}
