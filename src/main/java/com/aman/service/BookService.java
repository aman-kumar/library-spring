package com.aman.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aman.dao.BookDao;
import com.aman.domain.Book;

public class BookService {
	BookDao bookdao;

	public BookService() {
		bookdao = new BookDao();
	}

	public void create(Book book) {
		bookdao.createBook(book);
	}

	public List<Book> getList() {
		return bookdao.listBook();
		//return bookdao.listBook();
	}
	/*
	public void insert(Book book) {
		bookdao.insertBook(book);
	}

	public void getBookList() {
		List<Book> listOfBooks = new ArrayList<Book>();

		listOfBooks = bookdao.booksList();
		Iterator iterator = listOfBooks.iterator();
		while (iterator.hasNext()) {
			Book book1 = (Book) iterator.next();
			System.out.println(book1.getbookId());
			System.out.println(book1.getAuthor());
			System.out.println(book1.getName());
			System.out.println(book1.getDescription());
			System.out.println(book1.getPublisher());
			System.out.println(book1.getCopies());
		}
	}
	// public void search(Book book){
	// bookdao.searchBook(book);
	// }
	// public List<Book> getSearchedBookList(){
	// return bookdao.listSearchedBook();
	// }
*/
}