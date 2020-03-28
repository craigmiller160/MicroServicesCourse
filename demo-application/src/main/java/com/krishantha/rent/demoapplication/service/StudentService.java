package com.krishantha.rent.demoapplication.service;

import com.krishantha.rent.demoapplication.entity.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> getAllStudents();

}
