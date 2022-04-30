package com.example.demo.db;


import com.example.demo.classes.Student;
import com.example.demo.db.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> index() {
        return jdbcTemplate.query("SELECT st.id,st.name from student st", new StudentMapper());
    }

    public Student show(int id) {
        return jdbcTemplate.query("SELECT st.id,st.name from student st WHERE id =?", new Object[]{id}, new StudentMapper()).stream().findAny().orElse(null);
    }

    public void save(Student student) {
        jdbcTemplate.update("INSERT into student VALUES (default , ?)", student.getName());
    }

    public boolean check(int idStudent){
        return jdbcTemplate.queryForObject("Select exists(select id_student from mark where id_student=?)",
                Boolean.class, idStudent);
    }


}
