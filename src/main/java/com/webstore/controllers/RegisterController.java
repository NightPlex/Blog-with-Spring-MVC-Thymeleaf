// NightPlex productions

package com.webstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstore.forms.RegisterForm;
import com.webstore.models.User;
import com.webstore.services.NotificationService;
import com.webstore.services.UserRepository;
import com.webstore.services.UserService;


@Controller
public class RegisterController {
	
	@Autowired
    private UserRepository repository; 
	
	@Autowired
	private NotificationService nService;
	
	
	
	//Send Register form to be filled and validated::
	@RequestMapping("/users/register")
	public String registerUserForm(RegisterForm registerForm) {
		
		return "users/register";
		
	}
	
	
	// This what we give back to this controller
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public String registerUserForm(@Valid RegisterForm form, BindingResult result) {
		
		System.out.println("Username: " + form.getUsername() + "email: " + form.getEmail() + "Password: " + form.getPassword() + "Biography: " + form.getBiography()); // to test data
	
	   if (result.hasErrors()) {
		    nService.addErrorMessage("Please fill the form correctly!"); // Add error to our repository inmemory
            return "users/register";
       } else {
    	   
    	   
    	   repository.save(new User(form.getUsername(), form.getPassword(), "USER")); // saave to our in-memory h2 database. This is the user log files.
    	   System.out.println("Validation has no errors");
    	   
    	   nService.addInfoMessage("Successfully registered");
    	   
    	   return "redirect:/users/login";
    	   
       }
	   

      
		
	}
	
	

}
