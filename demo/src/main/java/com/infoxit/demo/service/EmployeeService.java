package com.infoxit.demo.service;

import java.util.List;

import com.infoxit.demo.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployee(Integer id);
	
	
	public List<Employee> getAllEmployees();
}
