package com.sbu.compiler.dto;

public class CodeResponseDTO {
	
	public String output;
	public String statusCode;
	public String memory;
	public String cpuTime;
	
	public CodeResponseDTO() {}
	
	public CodeResponseDTO(String output, String statusCode, String memory, String cpuTime) {
		super();
		this.output = output;
		this.statusCode = statusCode;
		this.memory = memory;
		this.cpuTime = cpuTime;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getCpuTime() {
		return cpuTime;
	}
	public void setCpuTime(String cpuTime) {
		this.cpuTime = cpuTime;
	}

	@Override
	public String toString() {
		return "CodeResponseDTO [output=" + output + ", statusCode=" + statusCode + ", memory=" + memory + ", cpuTime="
				+ cpuTime + "]";
	}
	
	
	
}
