package com.aman.libraryspring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {
    Record record;

    @Before
    public void setUp() throws Exception {
        record = new Record();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetBookRecord() {
        record.setBookRecord(1);
        assertEquals(1, record.getBookRecord());
    }

    @Test
    public void testSetBookRecord() {
        record.setBookRecord(2);
        assertEquals(2, record.getBookRecord());

    }

    @Test
    public void testGetBookId() {
        record.setBookId(1);
        assertEquals(1, record.getBookId());
    }

    @Test
    public void testSetBookId() {
        record.setBookId(2);
        assertEquals(2, record.getBookId());
    }

    @Test
    public void testGetStatus() {
        record.setStatus("available");
        assertEquals("available", record.getStatus());
    }

    @Test
    public void testSetStatus() {
        record.setStatus("issued");
        assertEquals("issued", record.getStatus());
    }

    @Test
    public void testGetStudentId() {
        record.setStudentId(1);
        assertEquals(1, record.getStudentId());
    }

    @Test
    public void testSetStudentId() {
        record.setStudentId(2);
        assertEquals(2, record.getStudentId());
    }

}
