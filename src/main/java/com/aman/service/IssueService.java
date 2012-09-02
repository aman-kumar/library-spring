package com.aman.service;

import java.util.ArrayList;
import java.util.List;

import com.aman.dao.RecordDao;
import com.aman.dao.StudentDao;
import com.aman.domain.Record;
import com.aman.domain.Student;

public class IssueService {
	List<Student> searchList = new ArrayList<Student>();

	StudentDao studentDao;
	RecordDao recordDao;

	public IssueService() {

		studentDao = new StudentDao();
		recordDao = new RecordDao();
	}
	List<Student> searchStudent;
	public void SearchStudent(Student student) {
		searchStudent=studentDao.searchStudent(student);
	}

	
	List<Record> searchRecord ;
	public void createRecord(Record record) {
		searchRecord=recordDao.createSearchRecord(record);
	}

	
	

	// now both above list will go as the argument to the to the update Record
	public void updateRecord() {
	recordDao.updateRecord(searchStudent, searchRecord);
		
	}

	public List<Record> getUpdatedRecord() {
		List<Record> recordList = new ArrayList<Record>();
		recordList = recordDao.getRecord();
		return recordList;
	}

}
