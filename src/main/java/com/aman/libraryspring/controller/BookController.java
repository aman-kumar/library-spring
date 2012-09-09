package com.aman.libraryspring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.service.BookService;

@Controller
public class BookController {

    Connection con;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/BookEntryPage", method = RequestMethod.GET)
    public ModelAndView book() {
        return new ModelAndView("BookEntryPage", "command", new Book());
    }

    @PostConstruct
    public void init() throws ServletException {
        System.out.println("It is in the init method :P");
        try {

            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:librarymanagementsystem199", "SA", "");
            System.out
                    .println("successfully connected to the database now it's the time to create the tables");
            try {
                String createTableBook = "CREATE TABLE Book (bookId VARCHAR(20) PRIMARY KEY, name VARCHAR(25),author VARCHAR(25),publication VARCHAR(25),description VARCHAR(50),noOfCopies INTEGER)";
                con.createStatement().executeUpdate(createTableBook);
                System.out
                        .println("table Book has been successfully created it seems now ");
            } catch (SQLException ex) {
                System.out.println("problem in creating Book Table");
                throw new IllegalStateException(ex);
            }
            try {
                // FOREIGN KEY REFERENCES Book(bookId)
                String bookRecordTable = "CREATE TABLE BookRecord (bookRecordId VARCHAR(25) PRIMARY KEY, bookId VARCHAR(20) ,status VARCHAR(20),studentId VARCHAR(25), FOREIGN KEY(bookId) REFERENCES Book(bookId))";
                con.createStatement().executeUpdate(bookRecordTable);
                System.out
                        .println("table BookRecord has been successfully created it seems now ");
            } catch (SQLException ex1) {
                System.out.println("problem in creating BookRecord");
                throw new IllegalStateException(ex1);
            }
            try {
                String createStudentTable = "CREATE TABLE Student (studentId VARCHAR(25) PRIMARY KEY,firstName VARCHAR(25),lastName VARCHAR(25),address VARCHAR(50),phoneNumber INTEGER,email VARCHAR(50))";
                con.createStatement().executeUpdate(createStudentTable);
                System.out
                        .println("table Student has been successfully created it seems now ");
            } catch (SQLException ex3) {
                System.out.println("problem in creating Student table");
                throw new IllegalStateException(ex3);
            }
        } catch (SQLException ex2) {
            System.out.println("problem occurred while creating Book table ");
            throw new IllegalStateException();
        }

    }

    List<Book> books = new ArrayList<Book>();

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book, Model model) {

        bookService.create(book);

        books = bookService.getList();
        model.addAttribute("books", books);
        return "BookUserScreen";

    }

}