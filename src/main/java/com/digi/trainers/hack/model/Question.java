package com.digi.trainers.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	private String question;
	
	private String optionA;
	
	private String optionB;
	
	private String optionC;
	
	private String optionD;
	
	private String correctOption;
	
	private Timestamp activatedAt;
	
	@ManyToOne
	@JoinColumn(name = "EVENT_ID")
	private Event event;
	
	public Question()
	{
		
	}
	
	public Question(String question, String optionA, String optionB, String optionC, String optionD,
			String correctOption) {
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Timestamp getActivatedAt() {
		return activatedAt;
	}

	public void setActivatedAt(Timestamp activatedAt) {
		this.activatedAt = activatedAt;
	}
	
	
}
