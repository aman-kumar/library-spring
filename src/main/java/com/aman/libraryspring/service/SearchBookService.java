package com.aman.libraryspring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;

@Service
public class SearchBookService {
	@Resource
	BookDao bookDao;
	@Resource
	RecordDao recordDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
/*
	public List<Record> search(Book book) {
		return recordDao.getRecordList(bookDao.searchBook(book));
	}
	*/
	List<Record> list=new ArrayList<Record>();
	public List<Record> search(Book book) {
		
		if((book.getAuthor() == "") && (book.getName() == "") ){
			return recordDao.listRecord();
		}else{
			return recordDao.getRecordList(bookDao.searchBook(book));
		}
		
	}
}
