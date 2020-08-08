package com.digi.trainers.hack.responses;

import com.digi.trainers.hack.model.User;

public class LoginResponse {
	private String jwt;
	private User user;
	
	public LoginResponse()
	{
		
	}
	
	@Override
	public String toString() {
		return "LoginResponse [jwt=" + jwt + ", user=" + user + "]";
	}

	public LoginResponse(String jwt, User user) {
		this.jwt = jwt;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwt()
	{
		return jwt;
	}
}
