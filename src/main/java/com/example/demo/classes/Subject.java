package com.example.demo.classes;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Subject {
    private int id;
    @Size(min = 2,max = 15, message = "Название должно быть 2-15 символов")
    private String title;

    @Size(min = 10, max = 300, message = "Время 10-300 символов")
    private int time;

    public Subject(){

    }

    public Subject(int id, String title, int time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
