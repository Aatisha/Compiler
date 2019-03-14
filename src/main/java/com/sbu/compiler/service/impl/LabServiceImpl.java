package com.sbu.compiler.service.impl;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbu.compiler.domain.Lab;
import com.sbu.compiler.domain.Question;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.LabDto;
import com.sbu.compiler.dto.QuestionDto;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.repository.LabRepository;
import com.sbu.compiler.repository.QuestionRepository;
import com.sbu.compiler.service.LabService;

@Service
public class LabServiceImpl implements LabService {
	@Autowired
	LabRepository labRepository;
	
	@Autowired
	QuestionRepository questionRepository;

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

	@Override
	public ResponseEntity<ResponseDto> addQuestion(QuestionDto question) {
		// TODO Auto-generated method stub
		Lab lab = new Lab();
		lab.setLabId(question.getLabId());
		
		Question q = new Question(question.getQuestionHead(),question.getQuestion(),question.getSampleCase(),question.getTestCase(),question.getProgrammingLang(),lab);
		
		questionRepository.save(q);
		ResponseDto r = new ResponseDto();
		r.setResponseMessage("Question added successfully.");
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@Override
	public ResponseDto fetchQuestionByLabId(int labId) {
		// TODO Auto-generated method stub
		Lab l = labRepository.findByLabId(labId);
		return transformToResponseDto(l);
	}

	private ResponseDto transformToResponseDto(Lab l) {
		// TODO Auto-generated method stub
		ResponseDto rDto = new ResponseDto();
		
		rDto.setQuestion(StreamSupport.stream(l.getQuestion().spliterator(),false).map(this::transformQuestionToDto).collect(Collectors.toList()));
		rDto.setResponseMessage("Success. List of Questions.");
		return rDto;
	}

	private QuestionDto transformQuestionToDto(Question q) {
		// TODO Auto-generated method stub
		QuestionDto qDto = new QuestionDto();
		qDto.setQuestionHead(q.getQuestionHead());
		qDto.setQuestion(q.getQuestion());
		qDto.setQuestionId(q.getQuestionId());
		qDto.setProgrammingLang(q.getProgrammingLang());
		qDto.setSampleCase(q.getSampleCase());
		return qDto;
	}
}
