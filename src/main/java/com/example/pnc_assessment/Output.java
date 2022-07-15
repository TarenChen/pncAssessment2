package com.example.pnc_assessment;

import java.util.List;
import java.util.UUID;

import org.springframework.validation.FieldError;

public class Output {
	private String status;
	private String welcomeMessage;
	private UUID uuid;
	private String city;
	private List<FieldError> errors;
	

	public Output() {
	}
	
	public void printOutput() {
		System.out.println(status);
		System.out.println(welcomeMessage);
		System.out.println(uuid);
		System.out.println(city);
		System.out.println(errors);
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> fieldErrors) {
		this.errors = fieldErrors;
		
	}
	
	
}
