package com.collaboration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CollaborationFunnelController {
	
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

}
