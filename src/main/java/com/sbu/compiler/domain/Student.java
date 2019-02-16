package com.sbu.compiler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="userId")
	private String userId;
	private String year;
	private String section;
	
	@OneToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	private User user;
	
	public Student() {}
	
	public Student(String userId, String year, String section, User user) {
		super();
		this.userId = userId;
		this.year = year;
		this.section = section;
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
