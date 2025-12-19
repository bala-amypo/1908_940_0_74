package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.exception.ResourceNotFoundException;

@Service

public class StudentServiceImple implements StudentService {
    // private final StudentRepository studentRepository;
    // public StudentServiceImple(StudentRepository studentRepository){
     //   this.studentRespoitory=studentRepository;
    // }
    @Autowired
    StudentRepository studentRepository;
 
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
    }
    public Student updatedata(Long id, Student student) {
        Student exits=getStudentById(id);
        exits.setName(student.getName());
        exits.setEmail(student.getEmail());
        return studentRepository.save(exits);
        // orElseThrow(()-> new ResourceNotFoundException( "Student not found"));
    } 
    public void deletedata(Long id) {
        Student student=getStudentById(id);
            studentRepository.delete(student);
    } 
}