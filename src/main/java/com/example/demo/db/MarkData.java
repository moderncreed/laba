package com.example.demo.db;

import com.example.demo.classes.Mark;
import com.example.demo.classes.Student;
import com.example.demo.db.Mapper.MarkMapper;
import com.example.demo.db.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkData {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MarkData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mark> index() {
        return jdbcTemplate.query("SELECT m.mark, m.id_student, m.id_subject, st.id, st.name, su.id, su.title, su.time from mark m " +
                "join student st on st.id = m.id_student " +
                "join subject su on su.id = m.id_subject ", new MarkMapper());
    }

    public boolean check(int idStudent, int idSubject){
        return jdbcTemplate.queryForObject("Select exists(select id_student,id_subject from mark where id_student=? and id_subject = ?)",
                Boolean.class, idStudent,idSubject);
    }

    public void save(Mark mark) {
        if (check(mark.getIdStudent(),mark.getIdSubject())==false) {
            jdbcTemplate.update("INSERT into mark VALUES (?,?,?)", mark.getIdStudent(), mark.getIdSubject(), mark.getMark());
        }
    }

    public void update(Mark updateMark) {
        jdbcTemplate.update("UPDATE mark SET mark = ? WHERE id_student = ? and id_subject = ?", updateMark.getMark(),updateMark.getIdStudent(),updateMark.getIdSubject());
    }

    public void delete() {
        jdbcTemplate.update("delete from student where id_students in (select id_student from mark where mark <=3)");
    }
    public double avgMark(int StudentId) {
        return jdbcTemplate.queryForObject("SELECT AVG(mark) FROM mark WHERE id_student = ?", double.class, StudentId);
    }



}
