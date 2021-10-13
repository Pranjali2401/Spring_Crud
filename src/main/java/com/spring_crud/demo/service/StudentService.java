package com.spring_crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_crud.demo.dao.StudentDao;
import com.spring_crud.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public Student addStudent(Student student) {
		Student st = studentDao.save(student);
		return st;
	}
	
	public Student displayStudent(long id) {
		return studentDao.getById(id);
	}
	

}
