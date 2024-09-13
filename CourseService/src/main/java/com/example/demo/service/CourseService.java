package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
@Service
public interface CourseService 
{
	List<Course> addCourse(Course c);
	List<Course> getAllCourses();
	Course getCourse(Integer cid);

}