package com.digi.trainers.hack.requests;

public class TeacherSignUpRequest {

	private String username;
	
	private String password;
	
	private String name;
	
	private String contactEmail;
	
	

	public TeacherSignUpRequest(String username, String password, String name, String contactEmail) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.contactEmail = contactEmail;
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

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	
}
