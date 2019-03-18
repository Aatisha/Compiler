package com.sbu.compiler.service;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.dto.SolutionDTO;

public interface SolutionService {
	public String execute(SolutionDTO param);
	public ResponseDto save(SolutionDTO param);
	public SolutionDTO submit(SolutionDTO param) throws JsonParseException, JsonMappingException, IOException, ParseException;
	
}
