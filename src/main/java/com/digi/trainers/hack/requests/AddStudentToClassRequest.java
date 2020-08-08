package com.digi.trainers.hack.requests;

public class AddStudentToClassRequest {

	private int classId;
	
	private int studentId;

	public AddStudentToClassRequest(int classId, int studentId) {
		this.classId = classId;
		this.studentId = studentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	
}
