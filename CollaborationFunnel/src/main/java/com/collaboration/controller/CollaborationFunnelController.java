package com.collaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collaboration.service.BlogService;

@Controller
public class CollaborationFunnelController {
	
	@Autowired(required = true)
	private BlogService blogService;
	
	@RequestMapping("/")
	public String Home()
	{
		return "index";
	}
	
	@RequestMapping("/blogpage")
	public String Blog()
	{
		return "blog";
	}
	
	@RequestMapping("/bloglist")
	public String getBlogList()
	{
		return "bloglist";
	}
	
	@RequestMapping("/blogview{blogId}")
	public String view(@PathVariable("blogId") int blogId, Model model) {
		System.out.println("view");
		model.addAttribute("blog", this.blogService.get(blogId));
		model.addAttribute("blogdetails", this.blogService.get(blogId));
		return "viewblog";
	}
	
	@RequestMapping("/userpage")
	public String User()
	{
		return "user";
	}
	
	@RequestMapping("/login")
	public String Login()
	{
		return "login";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/eventpage")
	public String event()
	{
		return "event";
	}

}
