package com.infoxit.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "training_title")
	private String trainingName;
	
	@Column(name = "training_date")
	private String date;
	
	@ManyToMany(targetEntity = Student.class, mappedBy = "training")
	private List<Student> students;

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(Integer id, String trainingName, String date, List<Student> students) {
		super();
		this.id = id;
		this.trainingName = trainingName;
		this.date = date;
		this.students = students;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", trainingName=" + trainingName + ", date=" + date + ", students=" + students
				+ "]";
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
