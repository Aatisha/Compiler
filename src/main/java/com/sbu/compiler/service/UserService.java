package com.sbu.compiler.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sbu.compiler.domain.Student;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.dto.StudentDto;
import com.sbu.compiler.dto.UserDto;

public interface UserService {
	
	public List<UserDto> getAllUsers();
	public List<StudentDto> getAllStudents();
	public ResponseDto findUserById(String user_id);
	public ResponseEntity<ResponseDto> addStudent(Student student);
	public ResponseEntity<ResponseDto> addUser(User user);
	public ResponseEntity<ResponseDto> loginUser(UserDto userDto);

}
