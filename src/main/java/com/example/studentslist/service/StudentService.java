package com.example.studentslist.service;

import com.example.studentslist.entity.StudentForm;

import java.util.List;

public interface StudentService {
    StudentForm addStudent(StudentForm student);

    void deleteById(Long id);

    List <StudentForm> getAllStudents();

}
