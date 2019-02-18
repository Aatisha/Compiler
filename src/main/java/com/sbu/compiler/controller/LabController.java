package com.sbu.compiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbu.compiler.dto.LabDto;
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
	public ResponseEntity<ResponseDto> addUser(@RequestBody LabDto lab) {
 
		return labService.addLab(lab);
	}

}
