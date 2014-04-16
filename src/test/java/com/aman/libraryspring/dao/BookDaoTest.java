package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;
import com.aman.libraryspring.domain.Book;

public class BookDaoTest {
    BookDao bookDao = new BookDao();
    Book book = new Book();
    Book book2 = new Book();
    Book book3=new Book();
    @BeforeClass
    public static void setUp() throws Exception {
        DbConfiguration.populateSqls("test-schema.sql");

    }


      @Test 
      public void testCreateBook() { 
    	  book.setName("Effective Java");
          book.setAuthor("Joshua Bloch");
          book.setDescription("Must read for every java developer");
          book.setPublisher("Addison Wesley");
          book.setCopies(10);
          List<Book> bookList=bookDao.createBook(book);
          System.out.println(bookList.get(0).toString());
          assertEquals("Effective Java", bookList.get(0).getName());
          assertEquals("Joshua Bloch", bookList.get(0).getAuthor());
          assertEquals("Must read for every java developer", bookList.get(0).getDescription());
          assertEquals("Addison Wesley", bookList.get(0).getPublisher());
          assertEquals(10, bookList.get(0).getCopies());
          assertEquals(1, bookList.get(0).getBookId());
          
      }
     
    
    @Test
    public void testListBook() {
        book2.setName("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setDescription("Must read for every java developer");
        book2.setPublisher("Addison Wesley");
        book2.setCopies(10);
        List<Book> list =bookDao.createBook(book2);
        System.out.println("bookid is :" +list.get(1).getBookId());
        assertEquals("Effective Java", list.get(1).getName());
        assertEquals("Joshua Bloch", list.get(1).getAuthor());
        assertEquals(2, list.get(1).getBookId());
        assertEquals("Must read for every java developer", list.get(1).getDescription());
        assertEquals("Addison Wesley", list.get(1).getPublisher());
        assertEquals(10, list.get(1).getCopies());

    }

    @Test
    public void testSearchBook() {
        book3.setName("HeadFirst Java");
        book3.setAuthor("Cathy Siera");
        //book2.setBookId("book2");
        book3.setDescription("Must read for every java developer");
        book3.setPublisher("Oreilly");
        book3.setCopies(10);
        List<Book> listBook=bookDao.createBook(book3);
        System.out.println("bookid for book3 is :" +listBook.get(0).getBookId());
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
