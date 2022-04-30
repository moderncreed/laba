package com.example.demo.controllers;

import com.example.demo.classes.Student;


import com.example.demo.db.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentData studentData;

    @Autowired
    public StudentController(StudentData studentData) {
        this.studentData = studentData;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("students", studentData.index());
        model.addAttribute("student", new Student());
        return "students/index";
    }

   }
