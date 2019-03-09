package com.sbu.compiler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private int questionId;
	
	private String questionHead;
	
	private String question;
	
	private String sampleCase;
	
	private String testCase;
	
	private String programmingLang;
	
	@ManyToOne
	@JoinColumn(name="labId")
	private Lab lab;

	public Question() {}

	

	/**
	 * @param questionHead
	 * @param question
	 * @param sampleCase
	 * @param testCase
	 * @param programmingLang
	 * @param lab
	 */
	public Question(String questionHead, String question, String sampleCase, String testCase, String programmingLang,
			Lab lab) {
		super();
		this.questionHead = questionHead;
		this.question = question;
		this.sampleCase = sampleCase;
		this.testCase = testCase;
		this.programmingLang = programmingLang;
		this.lab = lab;
	}



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

	public String getProgrammingLang() {
		return programmingLang;
	}

	public void setProgrammingLang(String programmingLang) {
		this.programmingLang = programmingLang;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", sampleCase=" + sampleCase
				+ ", testCase=" + testCase + ", programmingLang=" + programmingLang + ", lab=" + lab + "]";
	}

	
	

	

}
