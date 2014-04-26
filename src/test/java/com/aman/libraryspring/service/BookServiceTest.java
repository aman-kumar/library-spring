package com.aman.libraryspring.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.domain.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	BookService service;

	@Mock
	private BookDao bookDao;

	List<Book> bookList = new ArrayList<Book>();

	private Book mockedBook1 = new Book();

	private Book mockedBook2 = new Book();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new BookService();
		service.setDataAccess(bookDao);
		bookList.add(mockedBook1);
		bookList.add(mockedBook2);

	}

	@Test
	public void testGetList() {
		when(bookDao.getEnteredBook(mockedBook2)).thenReturn(bookList);
		List<Book> resultList = service.getList(mockedBook2);
		assertNotNull("list should not be null", resultList);
		
		verify(bookDao).getEnteredBook(mockedBook2);
	}
}
