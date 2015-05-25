package com.aman.libraryspring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	Book book;

	@Before
	public void setUp() throws Exception {
		book = new Book();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		book.setName("HeadFirst Java");
		assertEquals("HeadFirst Java", book.getName());
	}

	@Test
	public void testSetName() {
		book.setName("Effective Java");
		assertEquals("Effective Java", book.getName());

	}

	@Test
	public void testGetAuthor() {
		book.setAuthor("Joshua Bloch");
		assertEquals("Joshua Bloch", book.getAuthor());
	}

	@Test
	public void testSetAuthor() {
		book.setAuthor("Cathy Siera");
		assertEquals("Cathy Siera", book.getAuthor());
	}

	@Test
	public void testGetBookId() {
		book.setBookId(1);
		assertEquals(1, book.getBookId());
	}

	@Test
	public void testSetBookId() {
		book.setBookId(2);
		assertEquals(2, book.getBookId());
	}

	@Test
	public void testGetDescription() {
		book.setDescription("Must read for every Java developer");
		assertEquals("Must read for every Java developer",
				book.getDescription());
	}

	@Test
	public void testSetDescription() {
		book.setDescription("good book java beginner");
		assertEquals("good book java beginner", book.getDescription());
	}

	@Test
	public void testGetPublisher() {
		book.setPublisher("Addison wesley");
		assertEquals("Addison wesley", book.getPublisher());
	}

	@Test
	public void testSetPublisher() {
		book.setPublisher("Oreilly");
		assertEquals("Oreilly", book.getPublisher());
	}

	@Test
	public void testGetCopies() {
		book.setCopies(10);
		assertEquals(10, book.getCopies());
	}

	@Test
	public void testSetCopies() {
		book.setCopies(20);
		assertEquals(20, book.getCopies());
	}

}
