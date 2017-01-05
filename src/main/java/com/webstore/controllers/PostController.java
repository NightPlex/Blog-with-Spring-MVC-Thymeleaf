package com.webstore.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstore.models.Post;
import com.webstore.services.NotificationService;
import com.webstore.services.PostService;
import com.webstore.services.UserRepository;
import com.webstore.services.UserService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private NotificationService nService;
	
	@Autowired
    private UserService userService; 
	
	@RequestMapping("posts/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		
		Post post = postService.findById(id);
		
		if (post == null) {
			
			nService.addErrorMessage("Cannot find post with #" + id);
			return "redirect:/";
			
		}
		model.addAttribute("post", post);
		return "posts/view";
		
	}
	
	@RequestMapping("posts")
	public String posts(Model model) {
		
		ArrayList<Post> list = (ArrayList<Post>) postService.findAll();
		
		model.addAttribute("postList", list);

		
		return "posts";
		
	}
	
	@RequestMapping("posts/create")
	public String showPostView(Post post) {
		
		return "posts/createPost";
	}
	
	@RequestMapping(value = "/posts/create", method = RequestMethod.POST)  // Update application with new posts....
	public String savePost(Post post) {
		
		if(!post.getBody().isEmpty() && !post.getTitle().isEmpty()) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			postService.create(new Post(post.getTitle(), post.getBody(), auth.getName()));
			nService.addInfoMessage("Post created");
			
			return "redirect:/posts/create";
		} else {
			
			nService.addErrorMessage("Please enter a title and at least some content to body");
			return "redirect:/posts/create";
			
		}
		
		
	}
	
	
}
