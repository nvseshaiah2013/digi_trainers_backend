package com.digi.trainers.hack.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHERS")
public class Teacher {

	@Id
	private int id;
	
	private String name;
	
	private String contactEmail;
	
	@OneToMany
	private Set<Query> queries = new HashSet<Query>();
	
	@OneToMany
	private Set<OnlineClass> classes = new HashSet<OnlineClass>();
	
	@OneToMany
	private Set<Doubt> doubts = new HashSet<Doubt>();
	
	

	public Teacher() {
	}

	public Teacher(int id, String name, String contactEmail) {
		this.id = id;
		this.name = name;
		this.contactEmail = contactEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<Query> getQueries() {
		return queries;
	}

	public void setQueries(Set<Query> queries) {
		this.queries = queries;
	}

	public Set<OnlineClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<OnlineClass> classes) {
		this.classes = classes;
	}

	public Set<Doubt> getDoubts() {
		return doubts;
	}

	public void setDoubts(Set<Doubt> doubts) {
		this.doubts = doubts;
	}
	
	
}
