package com.infoxit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	private Integer depId;
	
	private String departmentName;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer depId, String departmentName) {
		super();
		this.depId = depId;
		this.departmentName = departmentName;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", departmentName=" + departmentName + "]";
	}
	
	
}
