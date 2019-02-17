package com.sbu.compiler.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbu.compiler.domain.Student;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.dto.StudentDto;
import com.sbu.compiler.dto.UserDto;
import com.sbu.compiler.repository.StudentRepository;
import com.sbu.compiler.repository.UserRepository;
import com.sbu.compiler.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	

	@Override
	public List<UserDto> getAllUsers() {
		
		return (StreamSupport.stream(userRepository.findAll().spliterator(),false).map(this::transformUserToDto).collect(Collectors.toList()));
	}
	
	private UserDto transformUserToDto(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setProfile(user.getProfile());
		userDto.setDept(user.getDept());
		
		return userDto;
		
	}

	@Override
	public List<StudentDto> getAllStudents() {
		return (StreamSupport.stream(studentRepository.findAll().spliterator(),false).map(this::transformStudentToDto).collect(Collectors.toList()));
	}
	
	private StudentDto transformStudentToDto(Student student)
	{
		StudentDto studentDto = new StudentDto();
		studentDto.setSection(student.getSection());
		studentDto.setYear(student.getYear());
		studentDto.setUser(transformUserToDto(student.getUser()));
		return studentDto;
		
	}

	@Override
	public ResponseDto findUserById(String user_id) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserId(user_id);
		ResponseDto rDto = new ResponseDto();
		if(user!=null) {
			if(user.getProfile().equals("Student"))
			{
				rDto = transformToResponseDto(user,studentRepository.findWithUserId(user.getUserId()));
				
			}
			else
			{
				rDto = transformToResponseDto(user, null);
			}
			rDto.setResponseMessage("Success.");
		}
		else
		{
			rDto.setResponseMessage("User Not Found.");
		}
		return rDto;
	}

	@Override
	public ResponseEntity<ResponseDto> addStudent(Student student) {
		// TODO Auto-generated method stub
		userRepository.save(student.getUser());
		studentRepository.save(student);
		ResponseDto r = new ResponseDto();
		r.setResponseMessage("Registered Successfully.");
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto> addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		ResponseDto r = new ResponseDto();
		r.setResponseMessage("Registered Successfully.");
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto> loginUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserIdAndPassword(userDto.getUserId(),userDto.getPassword());
		ResponseDto rDto = new ResponseDto();
		if(user!=null)
		{
			if(user.getProfile().equals("Student"))
			{
				rDto = transformToResponseDto(user,studentRepository.findWithUserId(user.getUserId()));
				
			}
			else
			{
				rDto = transformToResponseDto(user, null);
			}
			rDto.setResponseMessage("Login Successfull!");
			return new ResponseEntity<>(rDto,HttpStatus.OK);
		}
		else
		{
			rDto.setResponseMessage("Login Failed. Username or Password Incorrect. Try Again.");
			return new ResponseEntity<>(rDto,HttpStatus.UNAUTHORIZED);
		}
	}

	private ResponseDto transformToResponseDto(User user, Student student) {
		// TODO Auto-generated method stub
		ResponseDto rDto = new ResponseDto();
		rDto.setUserId(user.getUserId());
		rDto.setName(user.getName());
		rDto.setEmail(user.getEmail());
		rDto.setDept(user.getDept());
		rDto.setProfile(user.getProfile());
		if(student!=null) {
		rDto.setSection(student.getSection());
		rDto.setYear(student.getYear());
		}
		return rDto;
	}
}
