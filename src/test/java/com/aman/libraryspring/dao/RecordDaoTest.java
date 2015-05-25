package com.aman.libraryspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.libraryspring.DbConfiguration;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

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
		DbConfiguration.populateSqls("test-schema.sql");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

	@Test
	public void testListRecord() {
		book1.setBookId(1);
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

		for (Integer i = 1; i <= recordDao.listRecord().size(); i++) {

			assertEquals(i.intValue(), recordDao.listRecord().get(i - 1)
					.getBookRecord());
			assertEquals("available", recordDao.listRecord().get(i - 1)
					.getStatus());
		}
	}

	@Test
	public void testGetRecordList() {

		book2.setBookId(2);
		book2.setName("HeadFirst Java");
		book2.setAuthor("Cathy Siera");
		book2.setDescription("Must read for the new java learner");
		book2.setPublisher("Addison Wesley");
		book2.setCopies(10);
		bookDao.createBook(book2);
		book3.setBookId(3);
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

		for (int i = 0; i < recordDao.getRecordList(bookDao.searchBook(book4))
				.size(); i++) {
			assertEquals(2, recordDao.getRecordList(bookDao.searchBook(book4))
					.get(i).getBookId());
			assertEquals("", recordDao.getRecordList(bookDao.searchBook(book4))
					.get(i).getStudentId());

		}

	}

}
