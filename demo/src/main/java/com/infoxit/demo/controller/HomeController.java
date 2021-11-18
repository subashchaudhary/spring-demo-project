package com.infoxit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.demo.service.CalculatorService;
import com.infoxit.demo.service.StudentService;


@RestController
public class HomeController {

	@Autowired
	CalculatorService calculatorService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/hellow")
	public String hellow() {
		System.out.println("hellow method called");
	
		return "hi";
	}
	
	@PostMapping("/user")
	public String userInfo(@RequestParam("name") String name, @RequestParam("email") String email) {
		
		System.out.println("Username :"+ name);
		System.out.println("Email : "+ email);
		
		
		return "welcome "+ name + " to Spring session";
	}
	
	@GetMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		
		return "delete user of id :" + id;
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
		
		int result = calculatorService.add(num1, num2);
		return "Result is : "+ result;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		
		
		boolean res = studentService.deleteStudent(id);
		if(res) {
			return "Successfully deleted Student of id"+id;
		}
		
		return "coluld not deleted";
	}
	
}
