package com.aman.libraryspring.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

@RunWith(MockitoJUnitRunner.class)
public class SearchBookServiceTest {
SearchBookService service;

@Mock
BookDao bookDao;

@Mock
RecordDao recordDao;

@Mock
List<Record> recordList;

@Mock
Record record;
@Mock
Record record1;

@Mock
Book book;
@Mock
Book book1;

@Mock
List<Book> bookList;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new SearchBookService();
		service.setBookDao(bookDao);
		service.setRecordDao(recordDao);
		recordList.add(record);
		recordList.add(record1);
		bookList.add(book);
		bookList.add(book1);
	}

	@Test
	public void testSearch() {
	
		when(recordDao.getRecordList(bookDao.searchBook(book))).thenReturn(recordList);
		List<Record> resultList = service.search(book);
		System.out.println("Result --> " +resultList);
		assertNotNull("list should not be null", resultList);
	verify(recordDao).getRecordList(bookDao.searchBook(book));
	}

}
