package com.infoxit.demo.service;

import java.util.List;

import com.infoxit.demo.entity.Student;

public interface StudentCrudService {

	
	public Student updateStudent(Student student) throws Exception;
	
	public Student getStudentById(Integer id) throws Exception;
	
	public List<Student> getAllStudents() throws Exception;
	
}
