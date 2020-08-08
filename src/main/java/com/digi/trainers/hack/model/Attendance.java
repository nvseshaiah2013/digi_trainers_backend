package com.digi.trainers.hack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Attendance implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "EVENT_ID")
	private Event event;
	
	@Column(name =  "QUALITY")
	private float quality;
	
	public Attendance()
	{
		
	}

	public Attendance(Student student, Event event, float quality) {
		this.student = student;
		this.event = event;
		this.quality = quality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public float getQuality() {
		return quality;
	}

	public void setQuality(float quality) {
		this.quality = quality;
	}	
}
