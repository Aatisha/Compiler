package com.sbu.compiler.dto;

import java.util.List;

public class ResponseDto {

	private String userId;
	private String name;
	private String email;
	private String dept;
	private String profile;
	private String year;
	private String section;
	private String responseMessage;
	private List<LabDto> lab;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
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
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public List<LabDto> getLab() {
		return lab;
	}
	public void setLab(List<LabDto> lab) {
		this.lab = lab;
	}
	
	
	
	
	
}
