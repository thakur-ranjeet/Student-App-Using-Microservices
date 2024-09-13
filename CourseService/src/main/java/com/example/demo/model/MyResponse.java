package com.example.demo.model;

import java.util.List;

public class MyResponse
{
	Course crs;
	List<Student> studentList;
	
	public Course getCrs() {
		return crs;
	}
	public void setCrs(Course crs) {
		this.crs = crs;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> listOfStd) {
		this.studentList = listOfStd;
	}
	public MyResponse(Course crs, List<Student> studentList) {
		super();
		this.crs = crs;
		this.studentList = studentList;
	}
	public MyResponse() {
		super();
	}
	

}

