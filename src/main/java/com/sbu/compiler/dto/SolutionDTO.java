package com.sbu.compiler.dto;

public class SolutionDTO {
	private String solution_file;
	private String input;
	private String userId;
	private int labId;
	private int questionId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String user_id) {
		this.userId = user_id;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int lab_id) {
		this.labId = lab_id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int question_id) {
		this.questionId = question_id;
	}
	public String getSolution_file() {
		return solution_file;
	}
	public void setSolution_file(String script) {
		this.solution_file = script;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String stdin) {
		this.input = stdin;
	}
}
