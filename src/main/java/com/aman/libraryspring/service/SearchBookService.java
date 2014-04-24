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
		/*
		int i= bookDao.searchBook(book).size();
		System.out.println("inside searchBookService");
		for(int k=0;k<i;k++){
			System.out.println("inside for loop of searchBook Service checking bookDAORETURN");
			System.out.println("Book returned: "+bookDao.searchBook(book).get(k));
			list=recordDao.getRecordList(bookDao.searchBook(book).get(k));
		}
		*/
		//System.out.println("inside searchBookService");
		//System.out.println("returned size of record list: "+i);
		//for(int j=0;j<i;j++){
			//list=recordDao.getRecordList(bookDao.searchBook(book).get(j));
			//System.out.println("inside second search service loop: " +list.get(j));
			//System.out.println("inside second search service loop, List size: " +list.size());
		//}
		if((book.getAuthor() == "") && (book.getName() == "") ){
			return recordDao.listRecord();
		}else{
			return recordDao.getRecordList(bookDao.searchBook(book));
		}
		
	}
}
