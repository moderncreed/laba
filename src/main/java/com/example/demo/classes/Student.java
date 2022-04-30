package com.example.demo.classes;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student {
    private int id;
    @Size(min = 6, max = 30, message = "Имя 6-30 символов")
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}