package com.example.demo.db.Mapper;

import com.example.demo.classes.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("st.id"));
        student.setName(rs.getString("st.name"));
        return student;
    }
}
