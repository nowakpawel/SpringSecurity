package com.example.security.web.controller;

import com.example.security.repository.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private static final Logger logger = Logger.getLogger(StudentController.class.getName());
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Paweł Nowak"),
            new Student(2,"James Bond"),
            new Student(3,"John Doe")
    );

    @GetMapping( "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        logger.info("INFO:  Get specific student with id " + studentId);
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst() //TODO: create own exception
                .orElseThrow(() -> new IllegalStateException(("Student " + studentId + " does not exists!")));


    }
}
