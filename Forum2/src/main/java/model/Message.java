package model;

import java.util.Calendar;

public class Message {
    private Long id;
    private String title;
    private String content;
    private Calendar createdTime;
    private User creator;

    public Message(Long id, String title, String content, Calendar createdTime, User creator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
        this.creator = creator;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Calendar createdTime) {
        this.createdTime = createdTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}