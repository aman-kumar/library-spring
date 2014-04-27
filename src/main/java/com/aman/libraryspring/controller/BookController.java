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

import com.aman.libraryspring.ApplicationConfiguration;
import com.aman.libraryspring.ApplicationConstants;
import com.aman.libraryspring.DbConfiguration;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.service.BookService;
import com.aman.libraryspring.service.RecordService;

@Controller
public class BookController {

    Connection con;
    @Autowired
    private BookService bookService;
    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/BookEntryPage", method = RequestMethod.GET)
    public ModelAndView book() {
        return new ModelAndView("BookEntryPage", "command", new Book());
    } 	

    @PostConstruct
    public void init() throws ServletException {
        System.out.println("It is in the init method :P");
        try {
            DbConfiguration.populateSqls("db-schema.sql");


//            ApplicationConfiguration configuration = ApplicationConfiguration.INSTANCE;
//            Class.forName(configuration
//                    .getValue(ApplicationConstants.JDBC_DRIVERNAME));
//            con = DriverManager.getConnection(
//                    configuration.getValue(ApplicationConstants.JDBC_URL),
//                    "sa", "");
//            System.out
//                    .println("successfully connected to the database now it's the time to create the tables");
//            String createTableBook = "CREATE TABLE Book (bookId INTEGER IDENTITY, name VARCHAR(25),author VARCHAR(25),publication VARCHAR(25),description VARCHAR(50),noOfCopies INTEGER)";
//            con.createStatement().executeUpdate(createTableBook);
//            System.out
//                    .println("table Book has been successfully created it seems now ");
//            // FOREIGN KEY REFERENCES Book(bookId)
//           // String bookRecordTable = "CREATE TABLE BookRecord (bookRecordId VARCHAR(25) PRIMARY KEY , bookId VARCHAR(20) ,status VARCHAR(20),studentId VARCHAR(25), FOREIGN KEY(bookId) REFERENCES Book(bookId))";
//            String bookRecordTable = "CREATE TABLE BookRecord (bookRecordId INTEGER IDENTITY , bookId MEDIUMINT ,status VARCHAR(20),studentId VARCHAR(25), FOREIGN KEY(bookId) REFERENCES Book(bookId))";
//            con.createStatement().executeUpdate(bookRecordTable);
//            System.out
//                    .println("table BookRecord has been successfully created it seems now ");
//            String createStudentTable = "CREATE TABLE Student (studentId INTEGER IDENTITY,firstName VARCHAR(25),lastName VARCHAR(25),address VARCHAR(50),phoneNumber INTEGER,email VARCHAR(50))";
//            con.createStatement().executeUpdate(createStudentTable);
//            System.out
//                    .println("table Student has been successfully created it seems now ");

        } catch (SQLException ex2) {
            System.out.println("problem occurred while creating Book table ");
            throw new IllegalStateException(ex2);
        } 

    }

    List<Book> books = new ArrayList<Book>();

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book, Model model) {

    	List<Book> initialFindBookList =bookService.findBookList(book);
    	if(initialFindBookList.size() > 0){
    		System.out.println("Inside findBookList portion of code");
    		model.addAttribute("updateBook", initialFindBookList);
    		return "UpdateBookEntryScreen";
    	}
    	else{
        		int i=bookService.create(book);
        if(i == 1){
        	System.out.println("created book");
        	recordService.create(bookService.enteredBook(book).get(0));
        	System.out.println("created record");
        }
        
        
        
        
        books = bookService.getList(book);
        model.addAttribute("books", books);
        return "BookUserScreen";
    	}
    }

    List<Record> recordList = new ArrayList<Record>();

    @RequestMapping(value = "/addRecord", method = RequestMethod.GET)
    public String addRecord(@ModelAttribute Record record, Model model) {
        // recordService.create(record);
        recordList = recordService.getList();
        model.addAttribute("recordList", recordList);
        return "RecordDisplay";

    }
}
