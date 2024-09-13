package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Course;
import com.example.demo.model.MyResponse;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.List;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/courses")

public class CourseController 
{
	@Autowired
	CourseService ser;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//http://localhost:8082/api/v1/courses/add
			@PostMapping(value="/add",consumes="application/json")
			public ResponseEntity<List> addCourse(@RequestBody Course e)
			{
				List<Course> l=ser.addCourse(e);
				return new ResponseEntity<List>(l,HttpStatus.CREATED);
			}
		
		
		//http://localhost:8082/api/v1/courses/allcourses
		
		@GetMapping("/allcourses")
		public List<Course> getAllCourse()
		{
			List<Course>l=ser.getAllCourses();
			return l;
		}
		
		//http://localhost:8082/api/v1/courses/courseswithstudent/1
		@HystrixCommand(fallbackMethod = "handleStudentServiceDowntime")
		@GetMapping("/courseswithstudent/{cid}")
		public ResponseEntity<MyResponse> gallcourseswithstudent(@PathVariable Integer cid)
		{
			MyResponse requiredResponse =  new MyResponse();
			Course crs  = ser.getCourse(cid);
			requiredResponse.setCrs(crs);
						
			List<Student> listOfStd = restTemplate.getForObject("http://STUDENT-SERVICE/api/v1/students/allStudentofcrs/"+cid, List.class);
			
			requiredResponse.setStudentList(listOfStd);
			return new ResponseEntity<MyResponse>(requiredResponse, HttpStatus.OK);
		}
		

		public ResponseEntity<MyResponse> handleStudentServiceDowntime(@PathVariable Integer cid)
		{
			MyResponse requiredResponse =  new MyResponse();
			Course crs  = ser.getCourse(cid);
			requiredResponse.setCrs(crs);
			return new ResponseEntity<MyResponse>(requiredResponse, HttpStatus.OK);
			
		}
		
		

}

