package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository cr;
	@Override
	public List<Course> addCourse(Course c) {
		// TODO Auto-generated method stub
		cr.save(c);
		return cr.findAll();
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Course getCourse(Integer cid) {
		// TODO Auto-generated method stub
		Course c=cr.findById(cid).get();
		return c;
	}

}

