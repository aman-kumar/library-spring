package com.aman.libraryspring.controller;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/issue", method = RequestMethod.GET)
    public ModelAndView issue() {
        return new ModelAndView("Issue", "command", new Student());
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
        return "issueDetails";

    }
}