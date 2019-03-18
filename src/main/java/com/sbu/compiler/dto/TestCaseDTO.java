package com.sbu.compiler.dto;

public class TestCaseDTO {
	public String input;
	public String output;
	
	public TestCaseDTO() {}
	
	public TestCaseDTO(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	

}
