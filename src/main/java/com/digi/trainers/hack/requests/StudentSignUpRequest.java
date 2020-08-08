package com.digi.trainers.hack.requests;

public class StudentSignUpRequest {

	private String username;
	
	private String password;
	
	private String name;
	
	private String contactNo;	
	
	private String address;
	
	private String fatherName;
	
	private String fatherContact;
	
	private String motherName;
	
	private String motherContact;
		

	public StudentSignUpRequest(String username, String password, String name, String contactNo, String address,
			String fatherName, String fatherContact, String motherName, String motherContact) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.fatherName = fatherName;
		this.fatherContact = fatherContact;
		this.motherName = motherName;
		this.motherContact = motherContact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherContact() {
		return fatherContact;
	}

	public void setFatherContact(String fatherContact) {
		this.fatherContact = fatherContact;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherContact() {
		return motherContact;
	}

	public void setMotherContact(String motherContact) {
		this.motherContact = motherContact;
	}
	
	
}
