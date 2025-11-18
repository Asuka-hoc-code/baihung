package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String title;
    private List<Category> subCategories;
    private List<Topic> topics;

    public Category(String title) {
        this.title = title;
        this.subCategories = new ArrayList<>();
        this.topics = new ArrayList<>();
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}