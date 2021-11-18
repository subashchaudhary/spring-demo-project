package com.infoxit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infoxit.demo.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
