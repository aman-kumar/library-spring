package com.aman.libraryspring.interfaces;

import java.util.List;

import com.aman.libraryspring.domain.Student;

public interface StudentDAO {
    public void createStudent(Student student);

    public List<Student> getList();

    public List<Student> searchStudent(Student student);
}
