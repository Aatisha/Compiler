 package com.sbu.compiler.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lab")
public class Lab {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private int labId;
	
	private String labName;
	
	private String year;
	
	private String section;
	
	private String assignee;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="lab")
	private List<Question> question;
	
	public Lab() {}

	public Lab(String labName, String year, String section, String assignee, User user) {
		super();
		this.labName = labName;
		this.year = year;
		this.section = section;
		this.assignee = assignee;
		this.user = user;
	}



	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}
	
	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Lab [labId=" + labId + ", labName=" + labName + ", year=" + year + ", section=" + section
				+ ", assignee=" + assignee +"]";
	}

	
	
	

	
	
	
		

}
