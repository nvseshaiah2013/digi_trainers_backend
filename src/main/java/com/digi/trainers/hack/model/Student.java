package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CONTACT_NO", nullable = false)
	private String contactNo;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "FATHER_NAME", nullable = false)
	private String fatherName;
	
	@Column(name = "FATHER_CONTACT", nullable = false)
	private String fatherContact;
	
	@Column(name = "MOTHER_NAME", nullable = false)
	private String motherName;
	
	@Column(name = "MOTHER_CONTACT", nullable = false)
	private String motherContact;
	
	@ManyToOne
	@JoinColumn(name = "ON_CL_ID")
	private OnlineClass onlineClass;
	
	@OneToMany(mappedBy = "student")
	private Set<Doubt> doubts = new HashSet<Doubt>();
	
	

	public Student() {
	}

	public Student(int id, String name, String contactNo, String address, String fatherName, String fatherContact,
			String motherName, String motherContact) {
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.fatherName = fatherName;
		this.fatherContact = fatherContact;
		this.motherName = motherName;
		this.motherContact = motherContact;
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

	public OnlineClass getOnlineClass() {
		return onlineClass;
	}

	public void setOnlineClass(OnlineClass onlineClass) {
		this.onlineClass = onlineClass;
	}

	public Set<Doubt> getDoubts() {
		return doubts;
	}

	public void setDoubts(Set<Doubt> doubts) {
		this.doubts = doubts;
	}
	
	
}
