package com.aman.libraryspring.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Record {

    private int bookRecord;
    private int bookId;
    private String status;
    private int studentId;

    public int getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(int bookRecord) {
        this.bookRecord = bookRecord;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String toString(){
   	 return ToStringBuilder.reflectionToString(this);
   }
}
