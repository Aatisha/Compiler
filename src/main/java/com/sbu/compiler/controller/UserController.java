package com.sbu.compiler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbu.compiler.dto.StudentDto;
import com.sbu.compiler.dto.UserDto;
import com.sbu.compiler.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/all")
	public List<UserDto> fetchAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@RequestMapping("/students/all")
	public List<StudentDto> fetchAllStudents()
	{
		return userService.getAllStudents();
	}

}
