package com.sbu.compiler.controller;

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

import com.sbu.compiler.dto.LabDto;
import com.sbu.compiler.dto.QuestionDto;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.service.LabService;

@CrossOrigin
@RestController
@RequestMapping(value="api/v1/labs")
public class LabController {
	
	@Autowired
	LabService labService;
	
	//add lab session by respective dept hod
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addLab(@RequestBody LabDto lab) {
 
		return labService.addLab(lab);
	}
	
	//add question 
	@RequestMapping(value = "/question/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addQuestion(@RequestBody QuestionDto question) {
 
		return labService.addQuestion(question);
	}	
	
	@GetMapping(value="/question/{labId}")
	public ResponseEntity<ResponseDto> fetchTeacherByDept(@PathVariable int labId)
	{
		return new ResponseEntity<>(labService.fetchQuestionByLabId(labId), HttpStatus.OK);
	}
		

}
