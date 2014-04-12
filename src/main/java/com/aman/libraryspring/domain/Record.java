package com.aman.libraryspring.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Record {

    private String bookRecord;
    private String bookId;
    private String status;
    private String studentId;

    public String getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(String bookRecord) {
        this.bookRecord = bookRecord;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String toString(){
   	 return ToStringBuilder.reflectionToString(this);
   }
}
