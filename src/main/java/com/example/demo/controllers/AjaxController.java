package com.example.demo.controllers;

import com.example.demo.classes.Mark;
import com.example.demo.classes.Student;
import com.example.demo.classes.Subject;
import com.example.demo.db.MarkData;
import com.example.demo.db.StudentData;
import com.example.demo.db.SubjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    StudentData studentData;
    @Autowired
    SubjectData subjectData;
    @Autowired
    MarkData markData;

    @GetMapping("/get_student")
    public List<Student> getStudent() {
        return studentData.index();
    }

    @GetMapping("/get_subject")
    public List<Subject> getSubject() {
        return subjectData.index();
    }

    @GetMapping("/get_mark")
    public List<Mark> getMark() {
        return markData.index();
    }

    @PostMapping("/add_student")
    public void addStudent(@RequestBody Student student) {
        studentData.save(student);
    }

    @PostMapping("/add_subject")
    public void addSubject(@RequestBody Subject subject) {
        subjectData.save(subject);
    }

    @PostMapping("/add_mark")
    public void addMark(@RequestBody Mark mark) {
        markData.save(mark);
    }

    @PostMapping("/change_mark")
    public void changeMark(@RequestBody Mark mark) {
        markData.update(mark);
    }

    @PostMapping("/delete")
    public void delete() {
        markData.delete();
    }


}
