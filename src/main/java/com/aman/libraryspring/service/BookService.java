package com.aman.libraryspring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.domain.Book;

@Service
public class BookService {
	@Resource
	BookDao bookDao;

	public void setDataAccess(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	// BookDAO bookDao=mock(BookDao.class);
	// when(bookDao.listBook()).thenReturn("list");
	// Service service=new Service();
	// verify(service.getList());
	public List<Book> create(Book book) {
		return bookDao.createBook(book);

	}

	public List<Book> getList() {
		return bookDao.listBook();
	}

}
