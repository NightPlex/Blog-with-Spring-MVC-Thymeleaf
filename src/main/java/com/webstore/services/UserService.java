package com.webstore.services;

import java.util.List;

public interface UserService {

	boolean authenticate(String username, String password);
	List<String> listLoggedInUsers();
	
	
}
