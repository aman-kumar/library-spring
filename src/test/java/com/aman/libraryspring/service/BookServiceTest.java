package com.aman.libraryspring.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.domain.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	 BookService service;

	@Mock
	private BookDao bookDao;
	@Mock
	private List<Book> bookList;
	@Mock
	private Book mockedBook1;

	@Mock
	private Book mockedBook2;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service=new BookService();
		service.setDataAccess(bookDao);
		bookList.add(mockedBook1);
		bookList.add(mockedBook2);
		
	}

	@Test
	public void testGetList() {
		when(bookDao.listBook()).thenReturn(bookList);
		List<Book> resultList = service.getList();
		assertNotNull("list should not be null", resultList);
		verify(bookDao).listBook();
	}
}
