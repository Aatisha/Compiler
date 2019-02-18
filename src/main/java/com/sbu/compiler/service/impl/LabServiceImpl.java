package com.sbu.compiler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbu.compiler.domain.Lab;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.LabDto;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.repository.LabRepository;
import com.sbu.compiler.service.LabService;

@Service
public class LabServiceImpl implements LabService {
	@Autowired
	LabRepository labRepository;

	@Override
	public ResponseEntity<ResponseDto> addLab(LabDto lab) {
		User user = new User();
		user.setUserId(lab.getUserId());
		
		Lab l = new Lab(lab.getLabName(),lab.getYear(),lab.getSection(),lab.getAssignee(),user);
		
		labRepository.save(l);
		ResponseDto r = new ResponseDto();
		r.setResponseMessage("Lab Session added successfully.");
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
}
