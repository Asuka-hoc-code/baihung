package model;

import java.util.Date;

public class User {
    private String userName;
    private String password;
    private String email;
    private Date joinDate;

    public User(String userName, String password, String email, Date joinDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.joinDate = joinDate;
    }

    // Getters and setters

    public boolean verify(String username, String password) {
        return this.userName.equals(username) && this.password.equals(password);
    }

    // Các getter và setter cần thiết
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}