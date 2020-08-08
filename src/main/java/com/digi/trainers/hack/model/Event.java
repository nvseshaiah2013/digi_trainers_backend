package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "EVENTS")
public class Event implements Serializable{

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
	
	@Column(name = "ATT_LINK", nullable = false)
	private String attendanceLink;
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID", nullable = false)
	private Teacher teacher;
	
	@Column(name = "EV_DATE", nullable = false)
	private Timestamp eventDate;
	
	@ManyToOne
	@JoinColumn(name = "O_CLASS", nullable = false)
	private OnlineClass onlineClass;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();	
	
	public Event()
	{
		
	}
	
	public Event(String description, String subject, String topic, String meetingLink, String pptLink,
			String assignmentLink, Teacher teacher, Timestamp eventDate, OnlineClass onlineClass, String attendanceLink) {
		this.description = description;
		this.subject = subject;
		this.topic = topic;
		this.meetingLink = meetingLink;
		this.pptLink = pptLink;
		this.assignmentLink = assignmentLink;
		this.teacher = teacher;
		this.eventDate = eventDate;
		this.onlineClass = onlineClass;
		this.attendanceLink = attendanceLink;
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

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public OnlineClass getOnlineClass() {
		return onlineClass;
	}

	public void setOnlineClass(OnlineClass onlineClass) {
		this.onlineClass = onlineClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public String getAttendanceLink() {
		return attendanceLink;
	}

	public void setAttendanceLink(String attendanceLink) {
		this.attendanceLink = attendanceLink;
	}
	
	
}
