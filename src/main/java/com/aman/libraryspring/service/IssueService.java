package com.aman.libraryspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

@Service
public class IssueService {
    StudentDao studentDao;
    RecordDao recordDao;

    public IssueService() {
        studentDao = new StudentDao();
        recordDao = new RecordDao();
    }

    List<Student> searchStudent;

    public void searchStudent(Student student) {
        searchStudent = studentDao.searchStudent(student);
    }

    List<Record> searchRecord;

    public void createRecord(Record record) {
        searchRecord = recordDao.createSearchRecord(record);

    }

    public void updateRecord() {
        recordDao.updateRecord(searchStudent, searchRecord);
    }

    public List<Record> getUpdatedRecord() {
        return recordDao.getRecord();
    }
}