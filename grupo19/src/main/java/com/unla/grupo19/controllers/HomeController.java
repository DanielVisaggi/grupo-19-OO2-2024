package com.unla.grupo19.controllers;

import com.unla.grupo19.helpers.ViewHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("")
	public String home(Model model) {
		return ViewHelper.HOME_PAGE;
	}

}
