package com.infoxit.demo.controller;

import java.util.List;import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.demo.entity.Employee;
import com.infoxit.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeSerivce;
	
	@PostMapping(value =  "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmployeeDetails(@RequestBody Employee employee) {
		
		Employee savedEmployee = employeeSerivce.saveEmployee(employee);
		
		return savedEmployee;
	}
	
	@GetMapping("/allemployees") 
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeSerivce.getAllEmployees();
		return employees;
		
	}
}
