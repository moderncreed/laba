package com.example.demo.db.Mapper;

import com.example.demo.classes.Mark;
import com.example.demo.classes.Student;
import com.example.demo.classes.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkMapper implements RowMapper<Mark> {
    @Override
    public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mark mark = new Mark();
        Student student = new Student(rs.getInt("st.id"), rs.getString("st.name"));
        Subject subject = new Subject(rs.getInt("su.id"), rs.getString("su.title"),
                rs.getInt("su.time"));
        mark.setMark(rs.getInt("m.mark"));
        mark.setIdStudent(rs.getInt("m.id_student"));
        mark.setIdSubject(rs.getInt("m.id_subject"));
        mark.setStudent(student);
        mark.setSubject(subject);

        return mark;
    }
}
