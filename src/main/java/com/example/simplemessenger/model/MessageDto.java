package com.example.simplemessenger.model;

public class MessageDto {
    private Long id;

    public MessageDto(Long id, String content, Long sender) {
        this.id = id;
        this.content = content;
        this.sender = sender;
    }

    private Long sender;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String content;
}
