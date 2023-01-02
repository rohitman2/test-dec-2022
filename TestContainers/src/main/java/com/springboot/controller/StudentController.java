package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	
@Autowired
private StudentRepository studentRepository;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Student createStudent(@RequestBody Student student){
	return studentRepository.save(student);
	
}

@GetMapping
public List<Student> getAllStudents(){
    return studentRepository.findAll();
}
    
    
    
}
