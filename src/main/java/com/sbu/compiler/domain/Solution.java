//package com.sbu.compiler.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "solution")
//public class Solution {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	int solution_id;
//
//	@ManyToOne
//	@JoinColumn(name = "userId")
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name = "labId")
//	private Lab lab;
//
//	int result;
//
//	@ManyToOne
//	@JoinColumn(name = "questionId")
//	private Question question;
//	
//	String solution_file;
//
//	public int getSolution_id() {
//		return solution_id;
//	}
//
//	public void setSolution_id(int solution_id) {
//		this.solution_id = solution_id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public int getResult() {
//		return result;
//	}
//
//	public void setResult(int result) {
//		this.result = result;
//	}
//
//	public Lab getLab() {
//		return lab;
//	}
//
//	public void setLab(Lab lab) {
//		this.lab = lab;
//	}
//
//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
//
//	public String getSolution_file() {
//		return solution_file;
//	}
//
//	public void setSolution_file(String solution_file) {
//		this.solution_file = solution_file;
//	}
//}
