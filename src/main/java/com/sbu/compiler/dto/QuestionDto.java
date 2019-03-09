package com.sbu.compiler.dto;

public class QuestionDto {
	
	private int questionId;
	
	private String question;
	
	private String questionHead;
	
	private String programmingLang;
	
	private String sampleCase;
	
	private String testCase;
	
	private int labId;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	

	public String getQuestionHead() {
		return questionHead;
	}

	public void setQuestionHead(String questionHead) {
		this.questionHead = questionHead;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getProgrammingLang() {
		return programmingLang;
	}

	public void setProgrammingLang(String programmingLang) {
		this.programmingLang = programmingLang;
	}

	public String getSampleCase() {
		return sampleCase;
	}

	public void setSampleCase(String sampleCase) {
		this.sampleCase = sampleCase;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	
	
	

}
