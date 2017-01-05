package com.webstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstore.forms.LoginForm;
import com.webstore.services.NotificationService;
import com.webstore.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificationService nService;
	
	
	@RequestMapping("/users/login")
	public String loginPage(LoginForm loginForm) {
		
		System.out.println("Login in system. GET");
		
		return "users/login";
		
		
	}
	
	
	/*@RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(LoginForm loginForm, BindingResult bindingResult) {
		
		System.out.println("I will return the password of the user" + loginForm.getPassword());
		
        if (bindingResult.hasErrors()) {
             nService.addErrorMessage("Please fill the form correctly!");
             return "users/login";
        }

        if (!userService.authenticate(
             loginForm.getUsername(), loginForm.getPassword())) {
             nService.addErrorMessage("Invalid login!");
             return "users/login";
        }

        nService.addInfoMessage("Login successful");
        return "redirect:/";
    }*/
	
	
	
	
	
	

}
