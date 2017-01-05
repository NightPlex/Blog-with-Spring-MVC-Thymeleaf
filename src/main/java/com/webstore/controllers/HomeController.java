package com.webstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webstore.models.Post;
import com.webstore.services.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;

	@RequestMapping("/")
	public String index(Model model) {
		
		List<Post> latest5Post = postService.findLatest5();
		model.addAttribute("latest5", latest5Post);
		
		List<Post> latest3 = latest5Post.stream()
				.limit(3).collect(Collectors.toList());
		model.addAttribute("latest3", latest3);
		
		
		return "index";
	}
	
	
}
