package com.example.ashu.taskdatabase.Model;

public class Task {
    private long id;
    private String title;

    public Task(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
