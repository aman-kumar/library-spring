package com.aman.libraryspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Record;

@Service
public class RecordService {
    RecordDao recordDao;

    public RecordService() {
        recordDao = new RecordDao();
    }

    public void create(Record record) {
        recordDao.createRecord(record);
    }

    public List<Record> getList() {
        return recordDao.listRecord();
    }
}