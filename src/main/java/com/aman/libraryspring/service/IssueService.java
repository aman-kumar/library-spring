package com.aman.libraryspring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aman.libraryspring.dao.BookDao;
import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

@Service
public class IssueService {
    @Resource
    StudentDao studentDao;
    @Resource
    RecordDao recordDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
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