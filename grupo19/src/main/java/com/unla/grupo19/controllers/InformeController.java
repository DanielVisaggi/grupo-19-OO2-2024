package com.unla.grupo19.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.IUserService;
import com.unla.grupo19.services.implementation.InformeService;
import com.unla.grupo19.services.implementation.UserService;

@Controller
@RequestMapping("/informe")
public class InformeController {
	
	@Autowired
	private InformeService informeService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String listarInforme(Model model){
		User user=userService.findByUsernameQuery("admin");
		model.addAttribute("isAdmin", userService.isAdmin(user));
		model.addAttribute("informes", informeService.getAll());
		return  ViewHelper.IFORME_COMPRA;
		
	}

}
