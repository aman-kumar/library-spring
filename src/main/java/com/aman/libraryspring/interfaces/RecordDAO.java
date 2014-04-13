package com.aman.libraryspring.interfaces;

import java.util.List;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

public interface RecordDAO {
    public void createRecord(Book book);

    public void insertRecord(Record record);

    public List<Record> listRecord();

    public List<Record> getRecordList(List<Book> bookList);

    public List<Record> getBookStatus(int id);

    public List<Record> createSearchRecord(Record record);

    public void updateRecord(List<Student> searchStudent,
            List<Record> searchRecord);

    public void update(Student student, Record record);

    public List<Record> getRecord();
}
