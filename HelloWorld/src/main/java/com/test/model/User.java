package com.test.model;

public class User {

    private String id;
    private String username;
    private String password;
    private String picture;
    private String department;
    private int status;
    private String lastSignInDate;
    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String department, String picture) {
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.department = department;
        this.status = 1;
        this.lastSignInDate = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLastSignInDate() {
        return lastSignInDate;
    }

    public void setLastSignInDate(String lastSignInDate) {
        this.lastSignInDate = lastSignInDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", department='" + department + '\'' +
                ", status=" + status +
                ", lastSignInDate='" + lastSignInDate + '\'' +
                '}';
    }
}
