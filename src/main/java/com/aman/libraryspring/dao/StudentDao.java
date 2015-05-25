package com.aman.libraryspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aman.libraryspring.domain.Student;
import com.aman.libraryspring.interfaces.StudentDAO;

@Repository
public class StudentDao implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public StudentDao() {
		DataSource dataSource = new ConnectionUtils().getDataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createStudent(Student student) {
		jdbcTemplate
				.update("INSERT into Student (firstName, lastName, address, phoneNumber, email) values(?,?,?,?,?)",
						new Object[] { new String(student.getFirstName()),
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

			Student student = new Student();
			student.setStudentId(resultSet.getInt("studentId"));
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
