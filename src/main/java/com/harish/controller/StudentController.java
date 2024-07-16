package com.harish.controller;

import com.harish.entity.Student;
import com.harish.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudentDetails(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.saveStudentDetails(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudentDetails() {
        try {
            List<Student> students = studentService.getAllStudentDetails();
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentDetailsByStudentId(@PathVariable Integer studentId) {
        try {
            Student student = studentService.getStudentDetailsByStudentId(studentId);
            if (student != null) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentDetailsByStudentId(@PathVariable Integer studentId) {
        try {
            Student student = studentService.getStudentDetailsByStudentId(studentId);
            if (student != null) {
                studentService.deleteStudentDetailsByStudentId(studentId);
                return new ResponseEntity<>("Student details deleted successfully !!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No student details found For given student id", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudentDetailsByStudentId(@PathVariable Integer studentId, @RequestBody Student updatedStudentDetails) {
        try {
            Student student = studentService.updateStudentDetailsByStudentId(studentId, updatedStudentDetails);
            if (student != null) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
