package com.aman.service;

import java.util.List;

import com.aman.dao.BookDao;
import com.aman.dao.RecordDao;
import com.aman.domain.Book;
import com.aman.domain.Record;

public class SearchBookService {

	BookDao bookDao;
	RecordDao recordDao;

	public SearchBookService() {

		bookDao = new BookDao();
		recordDao = new RecordDao();
	}

	public List<Record> search(Book book) {
		
	return recordDao.getRecordList( bookDao.searchBook(book));
	}
/*
	List<Book> searchedBookList = bookDao.listSearchedBook();

	public void setBookRecordList() {
		recordDao.bookRecordList(searchedBookList);
	}

	public List<Record> getSearcRecordList() {
		return recordDao.getRecordList();
	}

	public void recordForIssue(List<Record> recordList) {
		// TODO Auto-generated method stub
		// issueDao.setRecordForIssue(recordList);
	}
	*/
}
