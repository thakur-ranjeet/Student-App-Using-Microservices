package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public interface StudentService
{
	List<Student> addStudent(Student e);
	Student updateStudent(Integer id,Student t);
	List<Student> deleteStudent(Integer id);
	Student getStudentById(Integer id);
	List<Student> getAllStudent();
	List<Student> getAllStudentOfCrs(Integer cid);
	

}

