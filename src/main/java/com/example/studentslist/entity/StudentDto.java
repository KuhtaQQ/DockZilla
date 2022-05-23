package com.example.studentslist.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthday;

    private String group;

    public StudentForm toStudent(){
        StudentForm student = new StudentForm();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymic(patronymic);
        student.setBirthday(birthday);
        student.setGroup(group);

        return student;
    }

    public static StudentDto fromUser(StudentForm student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPatronymic(student.getPatronymic());
        studentDto.setBirthday(student.getBirthday());
        studentDto.setGroup(studentDto.getGroup());


        return studentDto;
    }
}
