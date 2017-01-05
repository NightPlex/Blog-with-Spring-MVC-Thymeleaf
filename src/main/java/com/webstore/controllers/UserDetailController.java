package com.webstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webstore.services.UserRepository;
import com.webstore.services.UserService;


@Controller
public class UserDetailController {
	
	@Autowired
    private UserService userService; 
	
	@Autowired
    private UserRepository repository; 
	
	@RequestMapping("/users")
	public String showOnlineUsers(Model model) { // Give list of String to the view and iterate to show online users
		
		
		model.addAttribute("usersOnline", userService.listLoggedInUsers());
		model.addAttribute("allUsers", repository.findAll());
		
		return "users";
	}

}
