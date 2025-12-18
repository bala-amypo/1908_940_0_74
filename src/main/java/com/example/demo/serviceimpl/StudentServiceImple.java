package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRespository;
import com.example.demo.service.StudentService;
import com.example.demo.exception.ResourceNotFoundException;

@Service

public class StudentServiceImple implements StudentService {
    // private final StudentRespository studentRespository;
    // public StudentServiceImple(StudentRespository studentRespository){
     //   this.studentRespository=studentRespository;
    // }
    @Autowired
    StudentRespository studentRespository;
 
    public Student saveStudent(Student student) {

        return studentRespository.save(student);
    }
    public Student getStudentById(Long id){
        return studentRespository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
    }


}