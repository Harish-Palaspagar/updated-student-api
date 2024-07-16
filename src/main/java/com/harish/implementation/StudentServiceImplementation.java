package com.harish.implementation;

import com.harish.entity.Student;
import com.harish.repository.StudentRepository;
import com.harish.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentDetailsByStudentId(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentDetailsByStudentId(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudentDetailsByStudentId(Integer studentId, Student updatedStudentDetails) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setName(updatedStudentDetails.getName());
            student.setAge(updatedStudentDetails.getAge());
            student.setGender(updatedStudentDetails.getGender());
            student.setEmail(updatedStudentDetails.getEmail());
            student.setAddress(updatedStudentDetails.getAddress());
            return studentRepository.save(student);
        } else
            return null;
    }

}
