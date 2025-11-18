package model;

import java.util.Calendar;
import java.util.Stack;

public class Topic {
    private Long entryId;
    private String title;
    private Calendar createdTime;
    private String content;
    private User creator;
    private Stack<Message> messages;
    private Category category;

    public Topic(Long entryId, String title, Calendar createdTime, String content, User creator, Category category) {
        this.entryId = entryId;
        this.title = title;
        this.createdTime = createdTime;
        this.content = content;
        this.creator = creator;
        this.messages = new Stack<>();
        this.category = category;
    }

    public void addMessage(Message message) {
        this.messages.push(message);
    }

    public Message getNewMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.peek(); // Bài mới nhất là ở đỉnh stack (giả sử)
    }

    // Getters and setters

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Calendar createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Stack<Message> getMessages() {
        return messages;
    }

    public void setMessages(Stack<Message> messages) {
        this.messages = messages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}