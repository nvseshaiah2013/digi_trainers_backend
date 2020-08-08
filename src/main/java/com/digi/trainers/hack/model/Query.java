package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QUERY")
public class Query implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name = "SUBJECT", nullable = false)
	private String subject;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	@Column(name = "CREATE_ON", nullable = false)
	private Timestamp createdOn;
	

	public Query(String subject, String description, User user) {
		this.subject = subject;
		this.description = description;
		this.user = user;
		this.createdOn = Timestamp.valueOf(LocalDateTime.now());
	}
	
	public Query()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
