package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSES")
public class Response implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "QUESTION", nullable = false)
	private Question question;
	
	@Column(name ="STUDENT", nullable = false)
	private Student student;
	
	@Column(name = "RESP_TIME")
	private Timestamp timestamp;
	
	private String response;

	public Response(Question question, Student student, String response) {
		this.question = question;
		this.student = student;
		this.response = response;
		this.timestamp = Timestamp.valueOf(LocalDateTime.now());
	}
	
	public Response()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}	
}
