package com.infoxit.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infoxit.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	public Student findByName(String name);
	
//	@Query(value = "select * from student where id =:id", nativeQuery = true)
//	public Student getStudentById(Integer id);
	
//	public Student findByEmail(String email);
	//HQL -> hibernate query langauage
	//SQL -> structured query language
	@Modifying
	@Transactional
	@Query(value = "update student set status =:status where id =:id", nativeQuery = true)
	public int updateStudentStatus(Integer id, boolean status);
	

	
}
