package com.sky.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/toHome", method=RequestMethod.POST)
	public String home(@ModelAttribute() User user, Model model) {
		LOG.debug(user.getUsername() + " in controller toHome...");
		
		return "redirect:/home/"+user.getUsername();
	}
	
	@RequestMapping(value="/home/{username}", method=RequestMethod.GET)
	public String home(@PathVariable("username") String name, Model model) {
		LOG.debug(name + " in controller home...");
		model.addAttribute("username", name);
		return "home";
	}
	
}

class User {
	private String username;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
