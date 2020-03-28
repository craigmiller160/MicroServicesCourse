package com.krishantha.rent.demoapplication.controller;

import com.krishantha.rent.demoapplication.entity.Student;
import com.krishantha.rent.demoapplication.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final StudentService studentService;

    public MainController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String greeting() {
        return "Hello SpringBoot";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello")
    public String greeting2() {
        return "Hello SpringBoot from POST method";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student fetchStudentById(@PathVariable  int id) {
        return studentService.fetchStudentById(id);
    }

}
