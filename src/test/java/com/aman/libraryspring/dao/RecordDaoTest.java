package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

/*
 listRecord --> initial after entering the record of the book

 getRecordList-->while searching the book , it returns the list of the book --> record

 createSearchRecord -->again returns the book record for issue book , after selecting the book for issue purpose

 getRecord-->to get the updated record after issuing the book to the student.
 */
public class RecordDaoTest {
    Book book1 = new Book();
    Book book2 = new Book();
    Book book3 = new Book();
    Student student = new Student();
    Record record = new Record();
    RecordDao recordDao = new RecordDao();
    BookDao bookDao = new BookDao();

    @BeforeClass
    public static void setUp() throws Exception {
        DbConfiguration.populateSqls();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DbConfiguration.tearDownSchema();
    }

    /*
     * @Test public void testRecordDao() { fail("Not yet implemented"); }
     * 
     * @Test public void testCreateRecord() { fail("Not yet implemented"); }
     * 
     * @Test public void testInsertRecord() { fail("Not yet implemented"); }
     */
    @Test
    public void testListRecord() {
        book1.setBookId("book1");
        book1.setAuthor("Joshua Bloch");
        book1.setDescription("Must read for java developer");
        book1.setName("Effective Java");
        book1.setPublisher("Addison Wesley");
        book1.setCopies(5);
        bookDao.createBook(book1);
        recordDao.createRecord(book1);
        String value = "bookRecord";
        assertEquals(5, recordDao.listRecord().size());
        Iterator<Record> itr = recordDao.listRecord().iterator();
        for (Integer i = 0; i < recordDao.listRecord().size(); i++) {
            assertEquals("book1", recordDao.listRecord().get(i).getBookId());
            assertEquals(value.concat(i.toString()), recordDao.listRecord()
                    .get(i).getBookRecord());
            assertEquals("available", recordDao.listRecord().get(i).getStatus());
        }
    }

    // recordDao.listRecord();

    // getRecordList-->while searching the book , it returns the list of the
    // book --> record
    @Test
    public void testGetRecordList() {
        // add book, search that book and then compare, book2
        book2.setBookId("book2");
        book2.setName("HeadFirst Java");
        book2.setAuthor("Cathy Siera");
        book2.setDescription("Must read for the new java learner");
        book2.setPublisher("Addison Wesley");
        book2.setCopies(10);
        bookDao.createBook(book2);
        book3.setBookId("book3");
        book3.setName("Pragmmatic Programmer");
        book3.setAuthor("Aman Kumar");
        book3.setDescription("Must read for the new java learner");
        book3.setPublisher("Pragmmatic BookShelf");
        book3.setCopies(10);
        bookDao.createBook(book3);
        Book book4 = new Book();
        book4.setName("HeadFirst Java");
        book4.setAuthor("Cathy Siera");

        recordDao.getRecordList(bookDao.searchBook(book4));
        // return recordDao.getRecordList(bookDao.searchBook(book));
        for (int i = 0; i < recordDao.getRecordList(bookDao.searchBook(book4))
                .size(); i++) {
            assertEquals("book2",
                    recordDao.getRecordList(bookDao.searchBook(book4)).get(i)
                            .getBookId());
            assertEquals("", recordDao.getRecordList(bookDao.searchBook(book4))
                    .get(i).getStudentId());

        }
    }

}

/*
 * public List<Record> createSearchRecord(Record record) { return jdbcTemplate
 * .query(
 * "SELECT bookRecordId,bookId,status,studentId from BookRecord where bookRecordId=?"
 * , new Object[] { new String(record.getBookRecord()) }, new RecordMapper()); }
 */
/*
 * @Test public void testGetBookStatus() { fail("Not yet implemented"); }
 * 
 * 
 * 
 * @Test public void testUpdateRecord() { fail("Not yet implemented"); }
 * 
 * @Test public void testUpdate() { fail("Not yet implemented"); }
 * 
 * @Test public void testGetRecord() { fail("Not yet implemented"); }
 */

