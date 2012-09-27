package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;
import com.aman.libraryspring.domain.Book;

public class BookDaoTest {
    BookDao bookDao = new BookDao();
    Book book = new Book();
Book book2;
    @BeforeClass
    public static void setUp() throws Exception {
        DbConfiguration.populateSqls();
        
    }
/*
    @Test
    public void testCreateBook() {
        fail("Not yet implemented");
    }
*/
    @Test
    public void testListBook() {
        book.setName("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setBookId("book1");
        book.setDescription("Must read for every java developer");
        book.setPublisher("Addison Wesley");
        book.setCopies(10);
        bookDao.createBook(book);
        assertEquals("Effective Java", bookDao.listBook().get(0).getName());
        assertEquals("Joshua Bloch", bookDao.listBook().get(0).getAuthor());
        assertEquals("book1", bookDao.listBook().get(0).getBookId());
        assertEquals("Must read for every java developer", bookDao.listBook()
                .get(0).getDescription());
        assertEquals("Addison Wesley", bookDao.listBook().get(0).getPublisher());
        assertEquals(10, bookDao.listBook().get(0).getCopies());

    }
/*
    @Test
    public void testSearchBook() {
        fail("Not yet implemented");
    }
*/
    @AfterClass
    public static void tearDown() throws Exception {
        DbConfiguration.tearDownSchema();
    }
}
