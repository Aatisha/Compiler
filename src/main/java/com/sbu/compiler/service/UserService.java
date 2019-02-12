package com.sbu.compiler.service;

import java.util.List;

import com.sbu.compiler.dto.StudentDto;
import com.sbu.compiler.dto.UserDto;

public interface UserService {
	
	public List<UserDto> getAllUsers();
	public List<StudentDto> getAllStudents();

}
