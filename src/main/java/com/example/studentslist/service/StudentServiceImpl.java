package com.example.studentslist.service;

import com.example.studentslist.entity.StudentForm;
import com.example.studentslist.entity.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public StudentForm addStudent(StudentForm student) {
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setPatronymic(student.getPatronymic());
        student.setBirthday(student.getBirthday());
        student.setGroup(student.getGroup());
        StudentForm savedStudent = studentRepository.save(student);
        log.info("IN register - student: {} successfully registered", savedStudent);
        return savedStudent;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }

    @Override
    public List<StudentForm> getAllStudents() {
        List<StudentForm> result = studentRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }
}
