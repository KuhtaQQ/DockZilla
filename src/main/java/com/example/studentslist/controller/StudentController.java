package com.example.studentslist.controller;

import com.example.studentslist.entity.StudentDto;
import com.example.studentslist.entity.StudentForm;
import com.example.studentslist.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student/")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }



    @GetMapping
    public List<StudentForm> getAll(){
        List<StudentForm> list = studentService.getAllStudents();
        return list;
    }

    @PostMapping
    public StudentForm newStudent(StudentDto studentDto){
        StudentForm studentForm = studentService.addStudent(studentDto.toStudent());
        return studentForm;
    }

    @GetMapping(value = "{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id){
        studentService.deleteById(id);
    }
}
