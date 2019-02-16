package com.sbu.compiler.dto;

import com.sbu.compiler.dto.UserDto;;

public class StudentDto {
	
	private String userId;
	private String year;
	private String section;
	
	private UserDto user;

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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
	
	

}
