package com.sbu.compiler.service;

import com.sbu.compiler.dto.SolutionDTO;

public interface SolutionService {
	public String execute(SolutionDTO param);
	public void save(SolutionDTO param);
	
}
