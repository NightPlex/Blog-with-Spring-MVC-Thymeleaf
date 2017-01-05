package com.webstore.forms;

import java.util.List;

import javax.validation.constraints.Size;

public class RegisterForm {
	
	/*@Size(min = 2, message = "name must be at least 2 chars")
	private String name;*/
	
	@Size(min = 2, max = 30, message = "Username must be between 2 to 30 chars")
	private String username;
	
	private String email;
	
	
	@Size(min = 2, max = 30, message = "Password must be between 2 to 30 chars")
	private String password;
	
	
	@Size(min = 0, max = 500, message = "Max 500 chars")
	private String Biography;
	
	
	private String job;
	
	private List<String> interests;

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBiography() {
		return Biography;
	}

	public void setBiography(String biography) {
		Biography = biography;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	
	
	
	
	
	

}
