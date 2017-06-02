package com.test.model;

/**
 * Created by Administrator on 2017/5/31.
 */
public class Record {
    private String username;
    private String date;

    public Record(String username, String date) {
        this.username = username;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "username='" + username + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
