package com.infoxit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoxit.demo.entity.Employee;
import com.infoxit.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepo.save(employee);

		
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		 
		return (List<Employee>) employeeRepo.findAll();
	}

}
