package com.aman.libraryspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

@Repository
public class RecordDao {
    private JdbcTemplate jdbcTemplate;

    public RecordDao() {
        DataSource dataSource = new ConnectionUtils().getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createRecord(Book book) {

        String bookRecord = "bookRecord";
        Record record = new Record();
        Integer i;
        for (i = 0; i < book.getCopies(); i++) {

            record.setBookId(book.getBookId());
            record.setBookRecord(bookRecord.concat(i.toString()));
            record.setStatus("available");
            record.setStudentId("");
            this.insertRecord(record);
        }
    }

    public void insertRecord(Record record) {
        jdbcTemplate.update(
                "INSERT into BookRecord values(?,?,?,?)",
                new Object[] { new String(record.getBookRecord()),
                        new String(record.getBookId()),
                        new String(record.getStatus()),
                        new String(record.getStudentId()) });

    }

    public List<Record> listRecord() {
        return jdbcTemplate.query(
                "SELECT bookRecordId,bookId,status,studentId from BookRecord",
                new RecordMapper());
    }

    private static final class RecordMapper implements RowMapper<Record> {

        public Record mapRow(ResultSet resultSet, int rowNum)
                throws SQLException {
            Record record = new Record();
            record.setBookRecord(resultSet.getString("bookRecordId"));
            record.setBookId(resultSet.getString("bookId"));
            record.setStatus(resultSet.getString("status"));
            record.setStudentId(resultSet.getString("studentId"));

            // TODO Auto-generated method stub
            return record;
        }

    }

    public List<Record> getRecordList(List<Book> bookList) {

        List<Book> list = new ArrayList<Book>();
        list = bookList;
        Iterator<Book> itr = list.iterator();
        List<Record> recordList = new ArrayList<Record>();
        while (itr.hasNext()) {
            Book book = (Book) itr.next();
            recordList = this.getBookStatus(book.getBookId());
        }
        return recordList;
    }

    // and status=?,, "available"
    public List<Record> getBookStatus(String id) {
        return jdbcTemplate
                .query("SELECT bookRecordId,bookId,status,studentId from BookRecord where bookId=? ",
                        new Object[] { id }, new RecordMapper());
    }

    public List<Record> createSearchRecord(Record record) {
        return jdbcTemplate
                .query("SELECT bookRecordId,bookId,status,studentId from BookRecord where bookRecordId=?",
                        new Object[] { new String(record.getBookRecord()) },
                        new RecordMapper());
    }

    public void updateRecord(List<Student> searchStudent,
            List<Record> searchRecord) {

        List<Student> studentList = new ArrayList<Student>();
        List<Record> recordList = new ArrayList<Record>();
        studentList = searchStudent;
        recordList = searchRecord;
        Record record = new Record();
        Student student = new Student();
        Iterator<Student> itr = studentList.iterator();
        Iterator<Record> itr1 = recordList.iterator();
        while (itr.hasNext()) {
            student = itr.next();
        }
        while (itr1.hasNext()) {
            record = itr1.next();
        }
        this.update(student, record);
    }

    public void update(Student student, Record record) {
        jdbcTemplate
                .update("UPDATE BookRecord set status=? ,studentId=? where bookRecordId=?",
                        new Object[] { "issued", student.getStudentId(),
                                new String(record.getBookRecord()) });
    }

    public List<Record> getRecord() {

        return jdbcTemplate.query(
                "SELECT bookRecordId,bookId,status,studentId from BookRecord",
                new RecordMapper());
    }

}
