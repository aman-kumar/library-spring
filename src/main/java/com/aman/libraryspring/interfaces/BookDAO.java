package com.aman.libraryspring.interfaces;

import java.util.List;

import com.aman.libraryspring.domain.Book;

public interface BookDAO {
    public void createBook(Book book);

    public List<Book> listBook();

    public List<Book> searchBook(Book book);
}
