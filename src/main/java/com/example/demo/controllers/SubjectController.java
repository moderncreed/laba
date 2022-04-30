package com.example.demo.controllers;

import com.example.demo.classes.Student;
import com.example.demo.classes.Subject;
import com.example.demo.db.SubjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

   private final SubjectData subjectData;

    @Autowired
    public SubjectController(SubjectData subjectData) {
        this.subjectData = subjectData;
    }


    @GetMapping()
    public String indexSubject(Model model){
        model.addAttribute("subjects", subjectData.index());
        model.addAttribute("subject", new Subject());
        return "/subjects/index";
    }



}
