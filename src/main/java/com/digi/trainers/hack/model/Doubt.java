package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DOUBT")
public class Doubt implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "DESCR", nullable = false)
	private String description;
	
	@Column(name = "SUBJECT", nullable = false)
	private String subject;
	
	@Column(name = "TOPIC", nullable = false)
	private String topic;
	
	@Column(name = "MEET_LINK", nullable = false)
	private String meetingLink;
	
	@Column(name = "PPT_LINK", nullable = false)
	private String pptLink;
	
	@Column(name = "ASSIGN_LINK", nullable =false)
	private String assignmentLink;
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID", nullable = false)
	private Teacher teacher;
	
	@ManyToMany(mappedBy = "doubts")
	@JsonIgnore
	private Set<Student> students = new HashSet<Student>();
	
	@Column(name = "CREATE_DATE", nullable = false)
	private Timestamp createdOn;
	
	public Doubt()
	{
		
	}

	public Doubt(String description, String subject, String topic, String meetingLink, String pptLink,
			String assignmentLink, Teacher teacher) {
		this.description = description;
		this.subject = subject;
		this.topic = topic;
		this.meetingLink = meetingLink;
		this.pptLink = pptLink;
		this.assignmentLink = assignmentLink;
		this.teacher = teacher;

		this.createdOn = Timestamp.valueOf(LocalDateTime.now());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMeetingLink() {
		return meetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}

	public String getPptLink() {
		return pptLink;
	}

	public void setPptLink(String pptLink) {
		this.pptLink = pptLink;
	}

	public String getAssignmentLink() {
		return assignmentLink;
	}

	public void setAssignmentLink(String assignmentLink) {
		this.assignmentLink = assignmentLink;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.getStudents().add(student);
	}
	
}
