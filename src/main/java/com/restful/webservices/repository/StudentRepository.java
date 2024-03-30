package com.restful.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservices.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
