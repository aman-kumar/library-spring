package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;

import com.aman.libraryspring.domain.Student;

public class StudentDaoTest {
    StudentDao studentDao = new StudentDao();;
    Student student = new Student();
    Student student1 = new Student();

    @BeforeClass
    public static void setUp() throws Exception {
        DbConfiguration.populateSqls("test-schema.sql");

    }
    	
    

    @Test
    public void testGetList() {
        student.setFirstName("Aman");
        student.setLastName("Kumar");
        student.setEmailId("er.amankumar@gmail.com");
        student.setAddress("Ashiana Greens");
        student.setPhoneNumber(99999);
        //student.setStudentId("student1");
        System.out.println("Here student id set is: "+student.getStudentId());

        studentDao.createStudent(student);

        Iterator<Student> itr = studentDao.getList().iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            assertEquals("Aman", student.getFirstName());
            assertEquals("Kumar", student.getLastName());
            assertEquals("er.amankumar@gmail.com", student.getEmailId());
            assertEquals("Ashiana Greens", student.getAddress());
            assertEquals(99999, student.getPhoneNumber());
            assertEquals(1, student.getStudentId());
        }

    }

    @Test
    public void testSearchStudent() {
        Student student2 = new Student();
        Student student4 = new Student();
        student4.setFirstName("Abhishake");
        student4.setLastName("Kumar");
        student2.setFirstName("Aman");
        student2.setLastName("Kumar");
        student1.setFirstName("Abhishake");
        student1.setLastName("Dixit");
        student1.setEmailId("abhishake.dixit@gmail.com");
        student1.setAddress("MDI");
        student1.setPhoneNumber(99999);
        //student1.setStudentId("student2");
        System.out.println("Here student id set is: "+student1.getStudentId());
        System.out.println("Here student id set is: "+student2.getStudentId());
        studentDao.createStudent(student1);
        Iterator<Student> itr = studentDao.searchStudent(student2).iterator();
        while (itr.hasNext()) {
            Student student3 = itr.next();
            assertEquals(student2.getFirstName(), student3.getFirstName());
            assertEquals(student2.getLastName(), student3.getLastName());
        }

    }

    @AfterClass
    public static void tearDown() throws Exception {

        DbConfiguration.tearDownSchema();

    }

}
