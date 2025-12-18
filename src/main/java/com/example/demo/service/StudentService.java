package com.example.aiml.service;


import com.example.aiml.entity.Student;


public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(Long id); 
}
