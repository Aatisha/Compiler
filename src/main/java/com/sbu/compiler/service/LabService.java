package com.sbu.compiler.service;

import org.springframework.http.ResponseEntity;

import com.sbu.compiler.dto.LabDto;
import com.sbu.compiler.dto.QuestionDto;
import com.sbu.compiler.dto.ResponseDto;

public interface LabService {

	ResponseEntity<ResponseDto> addLab(LabDto lab);

	ResponseEntity<ResponseDto> addQuestion(QuestionDto question);

	ResponseDto fetchQuestionByLabId(int labId);

}
