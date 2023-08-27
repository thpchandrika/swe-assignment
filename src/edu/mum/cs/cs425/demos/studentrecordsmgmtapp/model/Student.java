package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {
	private long studentId;
	private String name;
	private LocalDate dateOfAdmission;
	

	public Student() {}
	
	public Student(long studentId, String name, LocalDate dateOfAdmission) {		
		this.studentId = studentId;
		this.name = name;
		this.dateOfAdmission = dateOfAdmission;
	}
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
	@Override
	public String toString() {
		return "studentId=" + studentId + ", name=" + name + ", dateOfAdmission=" + dateOfAdmission;
	}

}
