package com.sbu.compiler.dto;

import com.sbu.compiler.dto.UserDto;;

public class StudentDto {
	
	private String user_id;
	private String year;
	private String section;
	
	private UserDto user;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
