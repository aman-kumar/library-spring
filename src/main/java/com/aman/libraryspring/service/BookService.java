package com.aman.libraryspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.domain.Book;

@Service
public class BookService {
    BookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }

    public void create(Book book) {
        bookDao.createBook(book);

    }

    public List<Book> getList() {
        return bookDao.listBook();
    }

}
