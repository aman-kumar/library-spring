package com.aman.libraryspring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetStudentId() {
        student.setStudentId(1);
        assertEquals(1, student.getStudentId());
    }

    @Test
    public void testSetStudentId() {
        student.setStudentId(2);
        assertEquals(2, student.getStudentId());

    }

    @Test
    public void testGetFirstName() {
        student.setFirstName("Aman");
        assertEquals("Aman", student.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        student.setFirstName("Abhishake");
        assertEquals("Abhishake", student.getFirstName());

    }

    @Test
    public void testGetLastName() {
        student.setLastName("Kumar");
        assertEquals("Kumar", student.getLastName());
    }

    @Test
    public void testSetLastName() {
        student.setLastName("Dixit");
        assertEquals("Dixit", student.getLastName());
    }

    @Test
    public void testGetEmailId() {
        student.setEmailId("er.amankumar@gmail.com");
        assertEquals("er.amankumar@gmail.com", student.getEmailId());
    }

    @Test
    public void testSetEmailId() {
        student.setEmailId("er.amankumar@gmail.com");
        assertEquals("er.amankumar@gmail.com", student.getEmailId());
    }

    @Test
    public void testGetAddress() {
        student.setAddress("Ashiana greens");
        assertEquals("Ashiana greens", student.getAddress());
    }

    @Test
    public void testSetAddress() {
        student.setAddress("MDI");
        assertEquals("MDI", student.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        student.setPhoneNumber(9999);
        assertEquals(9999, student.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        student.setPhoneNumber(8898);
        assertEquals(8898, student.getPhoneNumber());
    }

}
