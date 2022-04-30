package com.example.demo.classes;

public class Mark {

    private int mark;
    private int idStudent;
    private int idSubject;
    private Student student;
    private Subject subject;

    public Mark() {

    }

    public Mark(int mark, int idStudent, int idSubject, Student student, Subject subject) {
        this.mark = mark;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.student = student;
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}