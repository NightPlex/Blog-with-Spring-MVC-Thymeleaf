package com.webstore.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	
	
	@Size(min = 2, max = 30, message = "Username must be between 2 to 30 chars")
	private String username;
	
	@NotNull
	@Size(min = 4, max = 50,  message = "Password must be more than 4 letters and less than 50")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
