package com.example.demo.db;

import com.example.demo.classes.Subject;
import com.example.demo.db.Mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class SubjectData {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Subject> index() {
        return jdbcTemplate.query("SELECT su.id, su.title, su.time from subject su", new SubjectMapper());
    }


    public void save(Subject subject) {
        jdbcTemplate.update("INSERT into subject VALUES (default , ?, ?)", subject.getTitle(), subject.getTime());
    }



}
