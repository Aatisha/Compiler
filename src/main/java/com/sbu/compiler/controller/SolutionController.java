package com.sbu.compiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbu.compiler.dto.SolutionDTO;
import com.sbu.compiler.service.SolutionService;

@CrossOrigin
@RestController
@RequestMapping("api/v1/solution")
public class SolutionController {
	@Autowired
	SolutionService solutionService;
	
	@RequestMapping(value="/execute",method=RequestMethod.POST )
	public String execute(@RequestBody SolutionDTO param)
	{
		return solutionService.execute(param);
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void save(@RequestBody SolutionDTO param)
	{
		solutionService.save(param);
		
	}

}
