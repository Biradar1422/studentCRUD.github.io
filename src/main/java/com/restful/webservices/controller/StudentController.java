package com.restful.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.model.Student;
import com.restful.webservices.repository.StudentRepository;
//import com.restful.webservices.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
    StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	List<Student> students = repo.findAll();
        return students;
    }
    
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
    	Student student = repo.findById(id).get();
		return student;
    	
    }
    
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
    	Student student1 = repo.save(student);
		return student1;
    	
    }
    
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id) {
    	Student student = repo.findById(id).orElse(null);
    	student.setAge(23);
    	student.setName("Aryan");
    	Student student1 = repo.save(student);
		return student1;
        }
    
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id) {
    	Student student = repo.findById(id).get();
    	repo.delete(student);
    }

}