package com.digi.trainers.hack.requests;

import java.sql.Timestamp;

public class NewEventRequest {
	
	private String description;	
	
	private String subject;
	
	private String topic;	
	
	private String meetingLink;	

	private String pptLink;
	
	private String assignmentLink;
	
	private Timestamp eventDate;
	
	private int classId;
	
	private String attendanceLink;
	
	public NewEventRequest(String description, String subject, String topic, String meetingLink, String pptLink,
			String assignmentLink, Timestamp eventDate, int classId, String attendanceLink) {
		this.description = description;
		this.subject = subject;
		this.topic = topic;
		this.meetingLink = meetingLink;
		this.pptLink = pptLink;
		this.assignmentLink = assignmentLink;
		this.eventDate = eventDate;
		this.classId = classId;
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

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getAttendanceLink() {
		return attendanceLink;
	}

	public void setAttendanceLink(String attendanceLink) {
		this.attendanceLink = attendanceLink;
	}
	
	
	
}
