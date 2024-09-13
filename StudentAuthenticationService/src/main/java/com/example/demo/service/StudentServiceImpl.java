package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository er;

	@Override
	public List<Student> addStudent(Student e) {
		// TODO Auto-generated method stub
		er.save(e);
		return er.findAll();
	}

	@Override
	public Student  updateStudent(Integer id,Student t) {
		// TODO Auto-generated method stub
		Optional<Student> obj=er.findById(id);
		Student e=obj.get();
		e.setSname(t.getSname());
		e.setCrsId(t.getCrsId());
		e.setSmail(t.getSmail());
		e.setPassword(t.getPassword());
		er.save(e);
		return er.findById(e.getSid()).get();
	}

	@Override
	public List<Student> deleteStudent(Integer id) {
		
		er.deleteById(id);
		return er.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> obj=er.findById(id);
		return obj.get();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public List<Student> getAllStudentOfCrs(Integer cid) {
		// TODO Auto-generated method stub
		
		return er.findByCrsId(cid);
	}
	}

