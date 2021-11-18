package com.infoxit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.demo.entity.Student;
import com.infoxit.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {

		System.out.println(student.toString());

		Student savedStudent = studentService.saveStudent(student);
		if (savedStudent != null) {
			return ResponseEntity.ok(savedStudent);
		} else {
			return ResponseEntity.ok("Could not saved data");
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {

		System.out.println(student.toString());
		try {
			Student savedStudent = studentService.updateStudent(student);
			if (savedStudent != null) {
				return ResponseEntity.ok(savedStudent);
			} else {
				return ResponseEntity.ok("Could not saved data");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("Something went wrong!!!");
		}
		

	}
	
	@RequestMapping(value = "/getstudent/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
		
		Student student = null;
		try {
			student = studentService.getStudentById(id);
			return ResponseEntity.ok(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("No Result found");
	}
	
	@GetMapping("/allstudents")
	public ResponseEntity<?> getAllStudents(){
		List<Student> students = null;
		try {
			students = studentService.getAllStudents();
			
			if(students.size() > 0) {
				return ResponseEntity.ok(students);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("No Students present");
		
	}
	
	@GetMapping("/studentbyname/{name}")
	public ResponseEntity<?> getStudent(@PathVariable("name") String name){
		
		return ResponseEntity.ok(studentService.getStudentByName(name));
		
	}
	
	@PatchMapping("/status/{id}/{status}")
	public ResponseEntity<?> setStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean status){
		
		return ResponseEntity.ok(studentService.setStatus(id, status));
	}
	
	
	//student book issues
	@PostMapping("/issuebook")
	public Student issueBook(@RequestBody Student student) {
		
		return studentService.issueBook(student);
	}
	
	@PostMapping("/enroll")
	public ResponseEntity<?> enrollStudent(@RequestBody Student student){
		
		return ResponseEntity.ok(studentService.enrollStudent(student));
	}
	
}
