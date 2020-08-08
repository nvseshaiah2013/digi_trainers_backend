package com.digi.trainers.hack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_MASTER")
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CONT_EMAIL", nullable = false)
	private String contactEmail;
	
	@Column(name = "CONTACT_NO", nullable = false)
	private String contactNo;	
	
	public Admin()
	{
		
	}

	public Admin(int id,String name, String contactEmail, String contactNo) {
		this.id = id;
		this.name = name;
		this.contactEmail = contactEmail;
		this.contactNo = contactNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
