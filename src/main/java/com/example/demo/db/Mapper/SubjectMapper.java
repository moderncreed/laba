package com.example.demo.db.Mapper;

import com.example.demo.classes.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();
        subject.setId(rs.getInt("su.id"));
        subject.setTitle(rs.getString("su.title"));
        subject.setTime(rs.getInt("su.time"));
        return subject;

    }
}
