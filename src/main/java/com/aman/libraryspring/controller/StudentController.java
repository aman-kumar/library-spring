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

import com.aman.libraryspring.domain.Student;
import com.aman.libraryspring.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/StudentDetailsEnterForm", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("StudentDetailsEnterForm", "command",
                new Student());
    }

    List<Student> students = new ArrayList<Student>();

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(@ModelAttribute Student student, Model model) {
        studentService.create(student);
        students = studentService.getList();
        model.addAttribute("students", students);
        return "StudentDetailsScreen";

    }
}
