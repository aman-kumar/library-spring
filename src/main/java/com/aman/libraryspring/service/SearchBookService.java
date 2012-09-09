package com.aman.libraryspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
@Service
public class SearchBookService {
    BookDao bookDao;
    RecordDao recordDao;

    public SearchBookService() {
        bookDao = new BookDao();
        recordDao = new RecordDao();
    }

    public List<Record> search(Book book) {
        return recordDao.getRecordList(bookDao.searchBook(book));
    }
}
