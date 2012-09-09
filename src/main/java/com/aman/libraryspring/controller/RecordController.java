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
import com.aman.libraryspring.service.RecordService;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/RecordEntry", method = RequestMethod.GET)
    public ModelAndView record() {
        return new ModelAndView("RecordEntry", "command", new Record());
    }

    List<Record> recordList = new ArrayList<Record>();

    @RequestMapping(value = "/addRecord", method = RequestMethod.GET)
    public String addRecord(@ModelAttribute Record record, Model model) {
        recordService.create(record);
        recordList = recordService.getList();
        model.addAttribute("recordList", recordList);
        return "RecordDisplay";

    }
}
