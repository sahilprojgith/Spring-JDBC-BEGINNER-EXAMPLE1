package com.telusko.SpringJDBCeg.Repository;

import com.telusko.SpringJDBCeg.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate; //we need to have getters and setters

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {


        String sql = "INSERT INTO Student(rollno,name, marks) values(?,?,?)";
        int rows = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());

        System.out.println(rows + " affected");

    }

    public List<Student> findAll() {
//        List<Student> studentListRepo = new ArrayList<>();
//        return studentListRepo;

        String sql = "SELECT * FROM Student";

//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student student = new Student();
//                student.setRollNo(rs.getInt("rollno"));
//                student.setName(rs.getString("name"));
//                student.setMarks(rs.getInt("marks"));
//                return student; //very imortant to change the null or it won't return anything.
//            }
//        };
//
//         return jdbcTemplate.query(sql, mapper); this all could be written in lamda expressions below
        //beacuse maprow() is a functional Interface.



         return jdbcTemplate.query(sql, ( rs,  rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student; //very important to change the null or it won't return anything.
        });



    }

}
