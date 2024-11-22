package com.example.simplemessenger.model;

import com.example.simplemessenger.model.User;

import java.util.List;

public class ChatDTO {
    private Long chatId;
    private List<User> participants; // Участники чата
    private String lastMessageContent; // Последнее сообщение
    private Long lastMessageSenderId; // ID отправителя последнего сообщения

    public ChatDTO(Long chatId, List<User> participants, String lastMessageContent, Long lastMessageSenderId) {
        this.chatId = chatId;
        this.participants = participants;
        this.lastMessageContent = lastMessageContent;
        this.lastMessageSenderId = lastMessageSenderId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getLastMessageContent() {
        return lastMessageContent;
    }

    public void setLastMessageContent(String lastMessageContent) {
        this.lastMessageContent = lastMessageContent;
    }

    public Long getLastMessageSenderId() {
        return lastMessageSenderId;
    }

    public void setLastMessageSenderId(Long lastMessageSenderId) {
        this.lastMessageSenderId = lastMessageSenderId;
    }

    // Геттеры и сеттеры
}
