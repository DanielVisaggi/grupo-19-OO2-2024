package com.unla.grupo19.controllers;

import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userService;
	@GetMapping("")
	public String home(Model model) {
		User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		return ViewHelper.HOME_PAGE;
	}

}
