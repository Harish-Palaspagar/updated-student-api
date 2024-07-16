package com.harish.service;

import com.harish.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student saveStudentDetails(Student student);

    Student getStudentDetailsByStudentId(Integer studentId);

    List<Student> getAllStudentDetails();

    void deleteStudentDetailsByStudentId(Integer studentId);

    Student updateStudentDetailsByStudentId(Integer studentId, Student updatedStudentDetails);

}
