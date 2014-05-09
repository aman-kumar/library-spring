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
	public int create(Book book) {
		return bookDao.createBook(book);

	}
	public List<Book> enteredBook(Book book){
		return bookDao.getEnteredBook(book);
	}  
	public List<Book> findBookList(Book book){
		return bookDao.findBook(book);
	}
	public List<Book> getList(Book book) {
		//return bookDao.listBook();
		return bookDao.getEnteredBook(book);
	}
	public List<Book> getBookById(int bookId){
	 return bookDao.searchBookById(bookId); 
	
	}
	
	public int updateBook(int bookId,int copies){
		return bookDao.updateBookCopies(bookId, copies);
	}
}
