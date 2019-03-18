package com.sbu.compiler.dto;

public class SolutionDTO {
	private int solution_id;
	private String solution_file;
	private String input;
	private String userId;
	private int labId;
	private int questionId;
	private String result;
	private String responseMessage;
	
	public int getSolution_id() {
		return solution_id;
	}
	public void setSolution_id(int solution_id) {
		this.solution_id = solution_id;
	}
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
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "SolutionDTO [solution_id=" + solution_id + ", solution_file=" + solution_file + ", input=" + input
				+ ", userId=" + userId + ", labId=" + labId + ", questionId=" + questionId + ", result=" + result
				+ ", responseMessage=" + responseMessage + "]";
	}
	
	
}
