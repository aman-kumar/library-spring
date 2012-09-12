package com.aman.libraryspring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;
import com.aman.libraryspring.service.IssueService;

@Controller
public class IssueController {
    @Autowired
    private IssueService issueService;

    Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    Record record;

    @RequestMapping(value = "/Issue", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

       // student.setFirstName(request.getParameter("firstName"));
       // student.setLastName(request.getParameter("lastName"));
      //  record.setBookRecord(request.getParameter("bookRecord"));
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("student", student);
        myModel.put("record", record);
        return new ModelAndView("Issue", "command", myModel);

    }

    List<Record> recordList = new ArrayList<Record>();

    @RequestMapping(value = "issueBook", method = RequestMethod.POST)
    public String issueBook(@ModelAttribute Record record,
            @ModelAttribute Student student, Model model) {
        issueService.createRecord(record);
        issueService.searchStudent(student);
        issueService.updateRecord();
        recordList = issueService.getUpdatedRecord();
        model.addAttribute("recordList", recordList);
        return "IssueDetails";

    }
}
