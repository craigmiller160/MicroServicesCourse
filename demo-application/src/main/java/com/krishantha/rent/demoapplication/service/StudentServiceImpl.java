package com.krishantha.rent.demoapplication.service;

import com.krishantha.rent.demoapplication.entity.Student;
import com.krishantha.rent.demoapplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
}
