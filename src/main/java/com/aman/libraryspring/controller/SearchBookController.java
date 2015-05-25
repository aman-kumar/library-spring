package com.aman.libraryspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.service.IssueService;
import com.aman.libraryspring.service.SearchBookService;

@Controller
public class SearchBookController {
	@Autowired
	private SearchBookService searchBookService;
	@Autowired
	private IssueService issueService;

	@RequestMapping(value = "/SearchBookForm", method = RequestMethod.GET)
	public ModelAndView search() {
		return new ModelAndView("SearchBookForm", "command", new Book());
	}

	List<Record> recordList = new ArrayList<Record>();

	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public String searchBook(@ModelAttribute Book book, Model model) {

		recordList = searchBookService.search(book);
		System.out.println("Record list size:  " + recordList.size());

		model.addAttribute("recordList", recordList);
		return "SearchDisplayResult";

	}

}
