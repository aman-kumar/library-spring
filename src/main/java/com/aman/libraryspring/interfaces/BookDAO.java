package com.aman.libraryspring.interfaces;

import java.util.List;

import com.aman.libraryspring.domain.Book;

public interface BookDAO {
    public int createBook(Book book);
    public List<Book> getEnteredBook(Book book);
    public List<Book> listBook();
    public List<Book> findBook(Book book);
    public List<Book> searchBook(Book book);
    public int updateBookCopies(int bookId, int copies);
    public List<Book> searchBookById(int bookId);
}
