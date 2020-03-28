package com.krishantha.rent.demoapplication.service;

import com.krishantha.rent.demoapplication.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    List<Student> getAllStudents();

    Student fetchStudentById(int id);

}
