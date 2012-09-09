package com.aman.libraryspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Student;

@Service
public class StudentService {
    StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public void create(Student student) {
        studentDao.createStudent(student);
    }

    public List<Student> getList() {
        return studentDao.getList();
    }
}
