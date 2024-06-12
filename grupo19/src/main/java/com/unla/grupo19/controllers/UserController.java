package com.unla.grupo19.controllers;

import java.util.Arrays;

import com.unla.grupo19.helpers.ViewHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo19.entities.User;
import com.unla.grupo19.services.implementation.UserRoleService;
import com.unla.grupo19.services.implementation.UserService;
import com.unla.grupo19.utils.Roles;


@Controller
@RequestMapping("/")
public class UserController {
	

	@Autowired
	private UserRoleService roleService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		model.addAttribute("usuario", new User());  //model: interactua con la vista(html)registro.html
		return ViewHelper.REGISTER_PAGE;
	}
	
	@PostMapping("/save")
	public RedirectView guardar(@ModelAttribute("usuario")User user) {
		System.out.println(user); 
		user.setRoles(Arrays.asList(roleService.traerPorNombre(Roles.ROLE_AUDITOR).get())); //se le setea el rol de audirot por defecto
		userService.saveOrUpdate(user);
		return new RedirectView("/"+ViewHelper.LOGIN_PAGE);
	}
	
	
	@GetMapping("/login")
	public String login(Model model,@RequestParam(name="error",required=false)String error,
	@RequestParam(name="logout", required=false)String logout) {
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		return ViewHelper.LOGIN_PAGE;
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "redirect:/"+ViewHelper.LOGIN_PAGE;
	}

	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/"+ViewHelper.HOME_PAGE;
	}
	

}
