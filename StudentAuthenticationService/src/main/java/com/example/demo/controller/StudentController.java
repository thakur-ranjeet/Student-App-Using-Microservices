package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController 
{
	@Autowired
	StudentService ss;
	
		@PostMapping(value="/add",consumes="application/json")
		public ResponseEntity<List> addStudent(@RequestBody Student e)
		{
			List<Student> l=ss.addStudent(e);
			return new ResponseEntity<List>(l,HttpStatus.CREATED);
		}
		/*JSON Object
		{
    "sid":2,
	"sname":"rohan",
	"crsId":2,
	"smail":"rohan@gmail.com",
	"password":"roh13"
	
	}*/
	
	
	//http://localhost:8081/api/v1/students/allStudent
	
	@GetMapping("/allStudent")
	public List<Student> getAllStudent()
	{
		List<Student>l=ss.getAllStudent();
		return l;
	}
	
	//http://localhost:8081/api/v1/students/1
	@GetMapping("/{sid}")
	public ResponseEntity<Student> getSingleStudent(@PathVariable int sid)
	{
		Student s=ss.getStudentById(sid);
		return  new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	
	//get all students of reqpective course id
	//http://localhost:8081/api/v1/students/allStudentofcrs/1
	
		@GetMapping("/allStudentofcrs/{cid}")
		public List<Student> getAllStudentOfDept(@PathVariable Integer cid)
		{
			List<Student>l=ss.getAllStudentOfCrs(cid);
			return l;
		}
	
	
	
	
	//http://localhost:8081/api/v1/students/update/1
		@PutMapping("/update/{sid}")
		public Student updateStudent(@PathVariable int sid,@RequestBody Student s)
		{
			Student s1=ss.updateStudent(sid, s);
			return  s1;
		}
	
		//http://localhost:8081/api/v1/employees/delete/5
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable int sid)
	{
		List<Student> s=ss.deleteStudent(sid);
		return new ResponseEntity<List<Student>>(s,HttpStatus.OK);
	}
	
	
	

	

}

