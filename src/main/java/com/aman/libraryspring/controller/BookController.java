package com.aman.libraryspring.controller;

import java.sql.Connection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        
        recordList = recordService.getList();
        model.addAttribute("recordList", recordList);
        return "RecordDisplay";

    }
    
    @RequestMapping(value = "/Update", method = RequestMethod.GET)
    public String update(@ModelAttribute Book book, Model model, @RequestParam(value = "bookId", required = false) Integer bookId) {
        
    	System.out.println("BookId is : "+bookId);
    	model.addAttribute("BookById",bookService.getBookById(bookId));
        return "UpdateEntry";
        }

    @RequestMapping(value = "/UpdateBookCopies", method = RequestMethod.GET)
    public String updateBookCopies(@ModelAttribute Book book, Model model,@RequestParam(value = "bookId", required = false) Integer bookId) {
        System.out.println("BookId inside updateBookCopies is : "+bookId);
    	System.out.println("No of copies to be added: "+book.getCopies());
    	

    	int i=bookService.updateBook(bookId, book.getCopies());
    	recordService.create(book);
    	System.out.println("updated record successfully");
    	//System.out.println("Book Name of updated book: "+book.getName());
    	if(i>0){
        return "aman";
    	}
    	else{
    		return "NotSuccessful";
    	}
        }
}
