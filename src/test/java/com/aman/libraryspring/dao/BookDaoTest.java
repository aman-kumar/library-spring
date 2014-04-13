package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;
import com.aman.libraryspring.domain.Book;

public class BookDaoTest {
    BookDao bookDao = new BookDao();
    Book book = new Book();
    Book book2 = new Book();

    @BeforeClass
    public static void setUp() throws Exception {
        DbConfiguration.populateSqls("test-schema.sql");

    }

    /*
     * @Test public void testCreateBook() { fail("Not yet implemented"); }
     */
    @Test
    public void testListBook() {
        book.setName("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setDescription("Must read for every java developer");
        book.setPublisher("Addison Wesley");
        book.setCopies(10);
        bookDao.createBook(book);
        System.out.println("bookid is :" +bookDao.listBook().get(0).getBookId());
        assertEquals("Effective Java", bookDao.listBook().get(0).getName());
        assertEquals("Joshua Bloch", bookDao.listBook().get(0).getAuthor());
        assertEquals(1, bookDao.listBook().get(0).getBookId());
        assertEquals("Must read for every java developer", bookDao.listBook()
                .get(0).getDescription());
        assertEquals("Addison Wesley", bookDao.listBook().get(0).getPublisher());
        assertEquals(10, bookDao.listBook().get(0).getCopies());

    }

    @Test
    public void testSearchBook() {
        book2.setName("HeadFirst Java");
        book2.setAuthor("Cathy Siera");
        //book2.setBookId("book2");
        book2.setDescription("Must read for every java developer");
        book2.setPublisher("Oreilly");
        book2.setCopies(10);
        bookDao.createBook(book2);
        System.out.println("bookid for book2 is :" +bookDao.listBook().get(1).getBookId());
        Book book3 = new Book();
        book3.setName("HeadFirst Java");
        book3.setAuthor("Cathy Siera");
        Iterator<Book> itr = bookDao.searchBook(book3).iterator();
        while (itr.hasNext()) {
            Book book4 = itr.next();
            assertEquals("Cathy Siera", book4.getAuthor());
            assertEquals("HeadFirst Java", book4.getName());
         //   assertEquals("book2", book4.getBookId());
            assertEquals("Must read for every java developer",
                    book4.getDescription());
            assertEquals("Oreilly", book4.getPublisher());
            assertEquals(10, book4.getCopies());
        }

    }

    @AfterClass
    public static void tearDown() throws Exception {
        DbConfiguration.tearDownSchema();
    }
}
