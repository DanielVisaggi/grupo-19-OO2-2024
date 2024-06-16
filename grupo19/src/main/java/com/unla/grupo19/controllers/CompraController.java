package com.unla.grupo19.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.implementation.ProductoService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CompraController {

	@Autowired
	private ProductoService productoService;
	

	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		ModelAndView mAV = new ModelAndView(ViewHelper.COMPRA_PAGE);
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	

}
