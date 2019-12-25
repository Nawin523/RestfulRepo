package com.rngs.restful.resource.model;

public class GenericResponse {
	
	private String status;
	private String message;
	 
	public GenericResponse() {
		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
