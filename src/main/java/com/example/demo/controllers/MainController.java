package com.example.demo.controllers;

import com.example.demo.classes.Student;
import com.example.demo.db.MarkData;
import com.example.demo.db.StudentData;
import com.example.demo.db.SubjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
public class MainController {
    private final StudentData studentData;
    private final SubjectData subjectData;
    private final MarkData markData;

    @Autowired
    public MainController(StudentData studentData, SubjectData subjectData, MarkData markData) {
        this.studentData = studentData;
        this.subjectData = subjectData;
        this.markData = markData;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("students", studentData.index());
        model.addAttribute("subjects", subjectData.index());
        return "marks/indexMark";
    }

    @GetMapping("/id={id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentData.show(id));
        model.addAttribute("avg", markData.avgMark(id));
        return "marks/showAvg";
    }


}


