package com.digi.trainers.hack.requests;

public class AddClassRequest{
	private int id;
	private String name;
	
	public AddClassRequest(int id,String name) 
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	
	
}
