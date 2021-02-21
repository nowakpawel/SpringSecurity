package com.example.security.web.controller;

import com.example.security.repository.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final Logger logger = Logger.getLogger(StudentController.class.getName());
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Paweł Nowak"),
            new Student(2,"James Bond"),
            new Student(3,"John Doe")
    );

    //TODO: create real repository - extends JpaRepository

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        logger.info("INFO:  "+ student + " added");
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        logger.info("INFO:  Deleting student with id " + studentId);
    }


    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        logger.info("INFO:  Updating student with id " + studentId);
    }

//    @GetMapping(path = "")
//    public void readStudent(Integer studentId) {
//        logger.info("INFO:  Student with id " + studentId + ": " + STUDENTS.get(studentId) );
//    }
}

