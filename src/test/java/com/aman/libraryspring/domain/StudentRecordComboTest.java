package com.aman.libraryspring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentRecordComboTest {
    Record record;
    Student student;
    StudentRecordCombo studentRecordCombo;

    @Before
    public void setUp() throws Exception {
        record = new Record();
        student = new Student();
        student.setFirstName("Aman");
        student.setEmailId("er.amankumar@gmail.com");
        student.setLastName("Kumar");
        student.setAddress("Ashiana Greens");
        student.setPhoneNumber(9899);
        student.setStudentId("student1");
        record.setBookId("book1");
        record.setBookRecord("bookRecord1");
        record.setStatus("issued");
        record.setStudentId("student1");
        studentRecordCombo = new StudentRecordCombo();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetStudent() {
        studentRecordCombo.setStudent(student);
        assertEquals("Aman", studentRecordCombo.getStudent().getFirstName());
        assertEquals("Kumar", studentRecordCombo.getStudent().getLastName());
        assertEquals("er.amankumar@gmail.com", studentRecordCombo.getStudent()
                .getEmailId());
        assertEquals("Ashiana Greens", studentRecordCombo.getStudent()
                .getAddress());
        assertEquals("student1", studentRecordCombo.getStudent().getStudentId());
        assertEquals(9899, studentRecordCombo.getStudent().getPhoneNumber());
    }

    @Test
    public void testSetStudent() {
        studentRecordCombo.setStudent(student);
        assertEquals("Aman", studentRecordCombo.getStudent().getFirstName());
        assertEquals("Kumar", studentRecordCombo.getStudent().getLastName());
        assertEquals("er.amankumar@gmail.com", studentRecordCombo.getStudent()
                .getEmailId());
        assertEquals("Ashiana Greens", studentRecordCombo.getStudent()
                .getAddress());
        assertEquals("student1", studentRecordCombo.getStudent().getStudentId());
        assertEquals(9899, studentRecordCombo.getStudent().getPhoneNumber());
    }

    @Test
    public void testGetRecord() {
        studentRecordCombo.setRecord(record);
        assertEquals("bookRecord1", studentRecordCombo.getRecord()
                .getBookRecord());
        assertEquals("book1", studentRecordCombo.getRecord().getBookId());
        assertEquals("issued", studentRecordCombo.getRecord().getStatus());
        assertEquals("student1", studentRecordCombo.getRecord().getStudentId());

    }

    @Test
    public void testSetRecord() {
        studentRecordCombo.setRecord(record);
        assertEquals("bookRecord1", studentRecordCombo.getRecord()
                .getBookRecord());
        assertEquals("book1", studentRecordCombo.getRecord().getBookId());
        assertEquals("issued", studentRecordCombo.getRecord().getStatus());
        assertEquals("student1", studentRecordCombo.getRecord().getStudentId());

    }

}
