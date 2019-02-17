package com.sbu.compiler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sbu.compiler.domain.Student;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.dto.StudentDto;
import com.sbu.compiler.dto.UserDto;
import com.sbu.compiler.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="api/v1/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//for logging the user
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> login(@RequestBody UserDto userDto) {
 
		return userService.loginUser(userDto);
	}
	
	//student signup
	@RequestMapping(value = "/signup/student", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addStudent(@RequestBody Student student) {
 
		ResponseDto r = userService.findUserById(student.getUser().getUserId());
		if(r.getResponseMessage().equals("Success."))
		{
			r = new ResponseDto();
			r.setResponseMessage("User Id Already Exists");
			return new ResponseEntity<>(r, HttpStatus.OK);
		}
		else
		{
			return userService.addStudent(student);
		}
	}
	
	//teacher signup
	@RequestMapping(value = "/signup/user", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addUser(@RequestBody User user) {
 
		ResponseDto r = userService.findUserById(user.getUserId());
		if(r.getResponseMessage().equals("Success."))
		{
			r = new ResponseDto();
			r.setResponseMessage("User Id Already Exists");
			return new ResponseEntity<>(r, HttpStatus.OK);
		}
		else
		{
			return userService.addUser(user);
		}
	}
	
	// display all the users 
	@RequestMapping("/all")
	public List<UserDto> fetchAllUsers()
	{
		return userService.getAllUsers();
	}
	
	//get user details by id
	@GetMapping(value="/{userId}")
	public ResponseEntity<ResponseDto> fetchOneUser(@PathVariable String userId)
	{
		ResponseDto r = userService.findUserById(userId);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	//display all students
	@RequestMapping("/students/all")
	public List<StudentDto> fetchAllStudents()
	{
		return userService.getAllStudents();
	}

}
