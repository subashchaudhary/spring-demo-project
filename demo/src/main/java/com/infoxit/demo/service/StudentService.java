package com.infoxit.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.infoxit.demo.entity.Student;
import com.infoxit.demo.repository.StudentRepository;

@Service
public class StudentService implements StudentCrudService {

	@Autowired
	StudentRepository studentRepo;

	public Student saveStudent(Student student) {

		return studentRepo.save(student);
	}

	public boolean deleteStudent(Integer id) {

		try {
			studentRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Student updateStudent(Student student) throws Exception {
		 
		if(student.getId() != null) {
			//update opertion
			Student updatedStudent = studentRepo.save(student);
			if(updatedStudent != null) {
				return updatedStudent;
			}else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public Student getStudentById(Integer id) throws Exception {
	 
		
		Optional<Student> existStudent  = studentRepo.findById(id);
		
		if(existStudent.get() != null) return existStudent.get();
		
		
		return null;
	}

	@Override
	public List<Student> getAllStudents() throws Exception {
		
		return studentRepo.findAll();
		
		
 
	}
	
	
	public Student getStudentByName(String name) {
		
		Student student = studentRepo.findByName(name);
		if(student!= null) {
			return student;
		}
		return null;
	}
	
	
	public Student setStatus(Integer id, boolean status) {
		
		int res = studentRepo.updateStudentStatus(id,status);
		if(res > 0 ) {
			return studentRepo.findById(id).get();
		}
		return null;
	}
	
	
	
	public Student issueBook(Student student) {
		return studentRepo.save(student);
	}

	
	public Student enrollStudent(Student student){
		
		
		
		return studentRepo.save(student);
		
		
		
	}
	
	
	
}
