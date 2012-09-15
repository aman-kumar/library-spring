package com.aman.libraryspring.dao;

import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.aman.libraryspring.domain.Student;

public class StudentDao {
    // --> create Student, listStudent,searchStudent
    private JdbcTemplate jdbcTemplate;

    public StudentDao() {
        Driver driver = new jdbcDriver();
        DataSource dataSource = new SimpleDriverDataSource(driver,
                "jdbc:hsqldb:mem:aname; user=SA");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createStudent(Student student) {
        jdbcTemplate.update(
                "INSERT into Student values(?,?,?,?,?,?)",
                new Object[] { new String(student.getStudentId()),
                        new String(student.getFirstName()),
                        new String(student.getLastName()),
                        new String(student.getAddress()),
                        new Integer(student.getPhoneNumber()),
                        new String(student.getEmailId()) });
    }

    public List<Student> getList() {
        return jdbcTemplate
                .query("SELECT studentId,firstName,lastName,email,address,phoneNumber from Student",
                        new StudentMapper());
    }

    private static final class StudentMapper implements RowMapper<Student> {

        public Student mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            // TODO Auto-generated method stub
            Student student = new Student();
            student.setStudentId(resultSet.getString("studentId"));
            student.setFirstName(resultSet.getString("firstName"));
            ;
            student.setLastName(resultSet.getString("lastName"));
            student.setAddress(resultSet.getString("address"));
            student.setEmailId(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getInt("phoneNumber"));
            return student;
        }

    }

    public List<Student> searchStudent(Student student) {
        return jdbcTemplate
                .query("SELECT studentId,firstName,lastName,address,phoneNumber,email from Student where firstName=? and lastName=?",
                        new Object[] { new String(student.getFirstName()),
                                new String(student.getLastName()) },
                        new StudentMapper());
    }
}
