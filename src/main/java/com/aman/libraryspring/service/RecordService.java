package com.aman.libraryspring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;

@Service
public class RecordService {
	@Resource
	RecordDao recordDao;

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public void create(Book book) {
		recordDao.createRecord(book);
	}

	public List<Record> getList() {
		return recordDao.listRecord();
	}
}
